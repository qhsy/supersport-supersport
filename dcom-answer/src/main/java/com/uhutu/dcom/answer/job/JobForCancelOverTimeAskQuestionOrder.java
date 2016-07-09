package com.uhutu.dcom.answer.job;

import java.util.List;

import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.model.MJobConfig;
import com.uhutu.zoocom.model.MResult;
import com.uhutu.zoodata.z.helper.JdbcHelper;
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
				"zc<DATE_SUB(NOW(),48 HOUR) and status='dzsd4888100110010001'", new MDataMap());
		if (infos != null && !infos.isEmpty()) {
			for (int i = 0; i < infos.size(); i++) {
				AwQuestionInfo info = infos.get(i);// 更新问达状态
				info.setStatus("dzsd4888100110010004");
				JdbcHelper.update(info, "status", "za");
			}
		}

		return null;
	}

}
