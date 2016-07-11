package com.uhutu.dcom.answer.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uhutu.dcom.answer.z.entity.AwAnswerRefundJob;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.model.MJobConfig;
import com.uhutu.zoocom.model.MResult;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.root.RootJob;

/**
 * 拒绝回答及到期未答问题退款任务
 * 注:微信实名认证每人每天每次最多20000额度，未实名认证每人每天每次最多2000额度
 * @author Administrator
 *
 */
public class JobForQuestionRefund extends RootJob {

	@Autowired
	private paygatepro
	
	@Override
	public MJobConfig upConfig() {
		MJobConfig jobConfig = new MJobConfig();
		jobConfig.setMaxLockTime(100);
		return jobConfig;
	}

	@Override
	public MResult process() {
		
		List<AwAnswerRefundJob> jobs = JdbcHelper.queryForList(AwAnswerRefundJob.class, "", "zc desc ", "status='1' and un_amount>0", new MDataMap());
		if(jobs!=null&&!jobs.isEmpty()){
			for (int i = 0; i < jobs.size(); i++) {
				AwAnswerRefundJob job = jobs.get(i);
				
			}
		}
		return new MResult();
	}

}
