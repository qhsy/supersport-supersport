package com.uhutu.dcom.activity.func;

import java.util.List;
import com.uhutu.dcom.activity.z.entity.AcActivityAnswerInfo;
import com.uhutu.dcom.activity.z.entity.AcActivityAnswerRelation;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class AcActivityAnswerRelFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		String[] answerCodes = input.getDataMap().get("answer_code").split(",");
		for (int i = 0; i < answerCodes.length; i++) {
			MDataMap insertMap = new MDataMap();
			insertMap.put("answer_code", answerCodes[i]);
			insertMap.put("activity_code", input.getDataMap().get("activity_code"));
			List<AcActivityAnswerRelation> rels = JdbcHelper.queryForList(AcActivityAnswerRelation.class, "", "",
					"answer_code=:answer_code", insertMap);
			for (int j = 0; j < rels.size(); j++) {
				MDataMap wh = new MDataMap();
				wh.put("code", rels.get(j).getActivityCode());
				AcActivityAnswerInfo info = JdbcHelper.queryOne(AcActivityAnswerInfo.class, "", "",
						"code=:code and status!='del'", wh);
				if (info != null && info.getCode().equals(input.getDataMap().get("activity_code"))) {
					result.setStatus(81130002);
					result.setError(TopHelper.upInfo(81130002, answerCodes[i]));
				} else if (info != null) {
					result.setStatus(81130001);
					result.setError(TopHelper.upInfo(81130001, answerCodes[i], info.getCode()));
				}
				if (!result.upFlagTrue()) {
					break;
				}
			}
			if (!result.upFlagTrue()) {
				break;
			} else {
				JdbcHelper.dataInsert(extendPageDefine.getPageSource().getTableName(), insertMap);
			}
		}
		return result;
	}
}
