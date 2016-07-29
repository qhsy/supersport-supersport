package com.uhutu.dcom.user.job;

import com.uhutu.zoocom.model.MJobConfig;
import com.uhutu.zoocom.model.MResult;
import com.uhutu.zooweb.root.RootJob;

/**
 * 已到期未回答问题变更状态、 给提问人退款及发送退款通知
 * 
 * @author Administrator
 *
 */
public class JobForMjAttention extends RootJob {

	@Override
	public MJobConfig upConfig() {
		MJobConfig jobConfig = new MJobConfig();
		jobConfig.setMaxLockTime(100);
		return jobConfig;
	}

	@Override
	public MResult process() {

		return new MResult();
	}

}
