package com.uhutu.dcom.answer.job;

import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.uhutu.dcom.answer.z.entity.AwAnswerRefundJob;
import com.uhutu.dcom.answer.z.entity.AwAnswerRefundLog;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.process.impl.PayGateProcess;
import com.uhutu.dcom.pay.z.request.WechatComPayBizRequest;
import com.uhutu.dcom.pay.z.response.WechatComPayResponse;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.model.MJobConfig;
import com.uhutu.zoocom.model.MResult;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.root.RootJob;

/**
 * 拒绝回答及到期未答问题退款任务 注:微信实名认证每人每天每次最多20000额度，未实名认证每人每天每次最多2000额度
 * 
 * @author xiegj
 *
 */
public class JobForQuestionRefund extends RootJob {

	@Autowired
	private PayGateProcess payGateProcess;

	@Override
	public MJobConfig upConfig() {
		MJobConfig jobConfig = new MJobConfig();
		jobConfig.setMaxLockTime(100);
		return jobConfig;
	}

	@Override
	public MResult process() {
		List<AwAnswerRefundJob> jobs = JdbcHelper.queryForList(AwAnswerRefundJob.class, "", "zc desc ",
				"status='1' and un_amount>0", new MDataMap());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (jobs != null && !jobs.isEmpty()) {
			for (int i = 0; i < jobs.size(); i++) {
				AwAnswerRefundJob job = jobs.get(i);
				AwAnswerRefundLog log = JdbcHelper.queryOne(AwAnswerRefundLog.class, "", "",
						"LEFT(time,10)='" + format.format(new Date()) + "' and status='1'", new MDataMap());
				if (log != null) {// 每个账号允许每天打款一次
					continue;
				} else {
					if (job.getUnAmount().compareTo(BigDecimal.valueOf(2000)) >= 0) {// 校验两千以上额度
						if (!tranMoneyAndSaveLog(job, job.getUnAmount().compareTo(BigDecimal.valueOf(20000)) > 0
								? BigDecimal.valueOf(20000) : job.getUnAmount())) {// 两千~两万额度转账失败再试两千及以下额度
							if (!tranMoneyAndSaveLog(job, BigDecimal.valueOf(2000))) {
								// 没有微信登录的发邮件通知运营处理
							}
						}
					} else if (job.getUnAmount().compareTo(BigDecimal.valueOf(2000)) < 0) {// 校验两千以下额度
						if (!tranMoneyAndSaveLog(job, job.getUnAmount())) {
							// 没有微信登录的发邮件通知运营处理
						}
					}
				}
			}
		}
		return new MResult();
	}

	/**
	 * 
	 * @param job
	 *            转账任务
	 * @param money
	 *            本次转账金额
	 * @return
	 */
	private boolean tranMoneyAndSaveLog(AwAnswerRefundJob job, BigDecimal money) {
		boolean flag = true;
		WechatComPayBizRequest request = new WechatComPayBizRequest();
		request.setAmount(job.getAmount());
		request.setOpenid(job.getWechatOpenId());
		request.setOrderCode(job.getOrderCode());
		request.setRomoteIP(ipconfig());
		request.setAmount(money);
		WechatComPayResponse bigRes = (WechatComPayResponse) payGateProcess.process(PayProcessEnum.WECHAT_COM, request,
				new MDataMap());
		if (StringUtils.isNotBlank(bigRes.getResult_code()) && "SUCCESS".equals(bigRes.getResult_code())) {
			saveLog(job.getCode(), money, job.getWechatOpenId(), bigRes.getReturn_msg());
			job.setAlAmount(job.getAlAmount().add(money));
			job.setUnAmount(job.getUnAmount().subtract(money));
			job.setStatus(job.getUnAmount().compareTo(BigDecimal.ZERO) == 0 ? "1" : "0");
			JdbcHelper.update(job, "al_amount,un_amount,status", "za");
		} else {
			flag = false;
		}
		return flag;
	}

	private String ipconfig() {
		String result = "";
		try {
			Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress ip = null;
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
				Enumeration addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					ip = (InetAddress) addresses.nextElement();
					if (ip != null && ip instanceof Inet4Address) {
						result = ip.getHostAddress();
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 退款日志
	 * 
	 * @param jobCode
	 *            退款任务编号
	 * @param money
	 *            本次退款金额
	 * @param userWechatId
	 *            用户微信编号
	 */
	private void saveLog(String jobCode, BigDecimal money, String userWechatId, String errorMsg) {
		AwAnswerRefundLog log = new AwAnswerRefundLog();
		log.setAmount(money);
		log.setCode(jobCode);
		log.setStatus("1");
		log.setTime(DateHelper.upNow());
		log.setWechatOpenId(userWechatId);
		log.setResponse(errorMsg);
		JdbcHelper.insert(log);
	}
}
