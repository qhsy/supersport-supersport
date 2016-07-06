package com.uhutu.sportcenter.z.api.answer;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.sportcenter.z.input.ApiAskQuestionInput;
import com.uhutu.sportcenter.z.result.ApiAskQuestionResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 提问时需要的个人信息
 * 
 * @author xiegj
 *
 */
@Component
public class ApiAskQuestion extends RootApiToken<ApiAskQuestionInput, ApiAskQuestionResult> {

	@Override
	protected ApiAskQuestionResult process(ApiAskQuestionInput input) {

		ApiAskQuestionResult result = new ApiAskQuestionResult();
		if (StringUtils.isNotBlank(input.getCode())) {
			UcUserinfoExt ext = JdbcHelper.queryOne(UcUserinfoExt.class, "user_code", input.getCode());
			UcUserinfo info = JdbcHelper.queryOne(UcUserinfo.class, "code", input.getCode());
			AwAnswerExpert expert = JdbcHelper.queryOne(AwAnswerExpert.class, "user_code", input.getCode());
			result.getShow().setAskMoney(expert.getCharge());
			result.getShow().setHeadUrl(ext.getAboutHead());
			result.getShow().setNickName(ext.getNickName());
			result.getShow().setTitle(expert.getTitle());
			result.getShow().setType(info.getType());
			result.getShow().setUserCode(input.getCode());
		}
		return result;
	}

}
