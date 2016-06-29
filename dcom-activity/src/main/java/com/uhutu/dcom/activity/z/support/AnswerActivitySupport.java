package com.uhutu.dcom.activity.z.support;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.activity.z.entity.AcActivityAnswerInfo;
import com.uhutu.dcom.activity.z.entity.AcActivityAnswerRelation;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;

public class AnswerActivitySupport {

	/**
	 * 根据问题编号获取问题所参加的当前有效期内已发布的活动信息
	 * 
	 */
	public AcActivityAnswerInfo getActivityInfoByAnswerCode(String answerCode) {
		AcActivityAnswerInfo info = null;
		if (StringUtils.isNotBlank(answerCode)) {
			AcActivityAnswerRelation relation = JdbcHelper.queryOne(AcActivityAnswerRelation.class, "answerCode",
					answerCode);
			if (relation != null && StringUtils.isNotBlank(relation.getActivityCode())) {
				MDataMap mWhereMap = new MDataMap();
				mWhereMap.put("code", relation.getActivityCode());
				mWhereMap.put("status", "dzsd4113100110010002");
				List<AcActivityAnswerInfo> infos = JdbcHelper.queryForList(AcActivityAnswerInfo.class, "", "",
						"code=:code and status=:status and endTime>=NOW() and startTime<=NOW()", mWhereMap);
				if (infos != null && !infos.isEmpty() && infos.size() > 0) {
					info = infos.get(0);
				}
			}
		}
		return info;
	}

	/**
	 * 根据活动编号获取活动信息
	 * 
	 */
	public AcActivityAnswerInfo getActivityInfo(String activityCode) {
		AcActivityAnswerInfo info = null;
		if (StringUtils.isNotBlank(activityCode)) {
			info = JdbcHelper.queryOne(AcActivityAnswerInfo.class, "code", activityCode);
		}
		return info;
	}

}
