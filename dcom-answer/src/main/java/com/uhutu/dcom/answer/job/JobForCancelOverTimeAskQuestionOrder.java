package com.uhutu.dcom.answer.job;

import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.uhutu.dcom.answer.z.entity.AwAnswerRefundJob;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.config.enums.SocialEnum;
import com.uhutu.dcom.user.z.entity.UcUserinfoSocial;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.model.MJobConfig;
import com.uhutu.zoocom.model.MResult;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;
import com.uhutu.zooweb.root.RootJob;

/**
 * 已到期未回答问题变更状态、 给提问人退款及发送退款通知
 * 
 * @author Administrator
 *
 */
public class JobForCancelOverTimeAskQuestionOrder extends RootJob {

	@Override
	public MJobConfig upConfig() {
		MJobConfig jobConfig = new MJobConfig();
		jobConfig.setMaxLockTime(100);
		return jobConfig;
	}

	@Override
	public MResult process() {

		List<AwQuestionInfo> infos = JdbcHelper.queryForList(AwQuestionInfo.class, "", "zc",
				"zc<DATE_SUB(NOW(),INTERVAL 48 HOUR) and status='dzsd4888100110010001'", new MDataMap());
		if (infos != null && !infos.isEmpty()) {
			for (int i = 0; i < infos.size(); i++) {
				AwQuestionInfo info = infos.get(i);// 更新问达状态
				info.setStatus("dzsd4888100110010004");
				JdbcHelper.update(info, "status", "za");
				if (JdbcHelper.queryOne(AwAnswerRefundJob.class, "order_code", info.getCode()) == null) {
					AwAnswerRefundJob job = new AwAnswerRefundJob();
					job.setOrderCode(info.getCode());
					job.setType("dzsd4888100110040001");// 到期未答
					job.setCode(WebHelper.upCode("TK"));
					job.setAmount(info.getMoney());
					job.setAlAmount(BigDecimal.ZERO);
					job.setRemark("问题48小时内未回答，退款处理");
					job.setStatus("0");
					job.setUnAmount(info.getMoney());
					job.setUserCode(info.getQuestionUserCode());
					UcUserinfoSocial us = JdbcHelper.queryOne(UcUserinfoSocial.class, "user_code",
							info.getQuestionUserCode(), "account_type", SocialEnum.wechat.name());
					if (us != null && StringUtils.isNotBlank(us.getAccountId())) {
						job.setWechatOpenId(us.getAccountId());
						JdbcHelper.insert(job);
					} else {
						// 没有微信登录的发邮件通知运营处理
					}
				}
			}
		}
		return new MResult();
	}

}
