package com.uhutu.dcom.answer.job;

import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
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
		WechatComPayBizRequest request = new WechatComPayBizRequest();
		if (jobs != null && !jobs.isEmpty()) {
			for (int i = 0; i < jobs.size(); i++) {
				AwAnswerRefundJob job = jobs.get(i);
				request.setAmount(job.getAmount());
				request.setOpenid(job.getWechatOpenId());
				request.setOrderCode(job.getOrderCode());
				request.setRomoteIP(ipconfig());
				WechatComPayResponse response = (WechatComPayResponse) payGateProcess.process(PayProcessEnum.WECHAT_COM,
						request, new MDataMap());
				if (StringUtils.isNotBlank(response.getResult_code()) && "SUCCESS".equals(response.getResult_code())) {// 先不校验金额进行退款操作
					saveLog(job.getCode(), job.getAmount());
					job.setAlAmount(job.getAmount());
					job.setUnAmount(BigDecimal.ZERO);
					job.setStatus("1");
					JdbcHelper.update(job, "al_amount,un_amount,status", "za");
				} else if (true) {// 校验两万额度

				} else if (true) {// 校验两千额度

				}
			}
		}
		return new MResult();
	}

	private String ipconfig() {
		String result = "";
		try {
			Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress ip = null;
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
				System.out.println(netInterface.getName());
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
	 * @param jobCode 退款任务编号
	 * @param money 本次退款金额
	 */
	private void saveLog(String jobCode,BigDecimal money){
		AwAnswerRefundLog log = new AwAnswerRefundLog();
		log.setAmount(money);
		log.setCode(jobCode);
		log.setStatus("1");
		log.setTime(DateHelper.upNow());
		JdbcHelper.insert(log);
	}
}
