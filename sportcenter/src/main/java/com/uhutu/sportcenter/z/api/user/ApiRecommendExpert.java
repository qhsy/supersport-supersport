package com.uhutu.sportcenter.z.api.user;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.answer.z.entity.AwPointRecommen;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.sportcenter.z.entity.RecommExpertInfo;
import com.uhutu.sportcenter.z.input.ApiRecommendExpertInput;
import com.uhutu.sportcenter.z.result.ApiRecommendExpertResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 推荐展示的达人信息
 * 
 * @author xiegj
 */
@Service
public class ApiRecommendExpert extends RootApiBase<ApiRecommendExpertInput, ApiRecommendExpertResult> {

	protected ApiRecommendExpertResult process(ApiRecommendExpertInput input) {
		ApiRecommendExpertResult result = new ApiRecommendExpertResult();
		List<AwPointRecommen> list = JdbcHelper.queryForList(AwPointRecommen.class, "", "-sort",
				"type='dzsd4888100110030004'", new MDataMap(), (input.getPagination() - 1) * input.getNum(),
				input.getNum());
		StringBuffer str = new StringBuffer();
		if (list != null && !list.isEmpty() && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (i == list.size() - 1) {
					str.append("'" + list.get(i).getAnswerCode() + "'");
				} else {
					str.append("'" + list.get(i).getAnswerCode() + "',");
				}
			}
			List<UcUserinfoExt> us = JdbcHelper.queryForList(UcUserinfoExt.class, "",
					" field(user_code," + str.toString() + ")", " user_code in(" + str.toString() + ")",
					new MDataMap());
			if (us != null && !us.isEmpty()) {
				for (int i = 0; i < us.size(); i++) {
					RecommExpertInfo recommExpertInfo = new RecommExpertInfo();
					UcUserinfoExt uie = us.get(i);
					BeanUtils.copyProperties(uie, recommExpertInfo);
					UcUserinfo uui = JdbcHelper.queryOne(UcUserinfo.class, "code", recommExpertInfo.getUserCode());
					AwAnswerExpert answerExpert = JdbcHelper.queryOne(AwAnswerExpert.class, "userCode",recommExpertInfo.getUserCode());
					if (uui != null) {
						recommExpertInfo.setType(uui.getType());
					}
					if(answerExpert != null){
						
						recommExpertInfo.setTitle(answerExpert.getTitle());
						
					}
					result.getList().add(recommExpertInfo);
				}
			}
		}
		return result;
	}
}
