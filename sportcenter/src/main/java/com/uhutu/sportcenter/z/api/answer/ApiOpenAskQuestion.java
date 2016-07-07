package com.uhutu.sportcenter.z.api.answer;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.sportcenter.z.input.ApiOpenAskQuestionInput;
import com.uhutu.sportcenter.z.result.ApiOpenAskQuestionResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 开通问达
 *
 */
@Component
public class ApiOpenAskQuestion extends RootApiToken<ApiOpenAskQuestionInput, ApiOpenAskQuestionResult> {

	@Override
	protected ApiOpenAskQuestionResult process(ApiOpenAskQuestionInput input) {

		ApiOpenAskQuestionResult result = new ApiOpenAskQuestionResult();
		if (StringUtils.isNotBlank(upUserCode())) {
			AwAnswerExpert expert = JdbcHelper.queryOne(AwAnswerExpert.class, "user_code", upUserCode());
			if (expert != null) {
				expert.setStatus("dzsd4699100110010001");
				JdbcHelper.update(expert, "status", "za");
			} else {
				expert = new AwAnswerExpert();
				expert.setUserCode(upUserCode());
				expert.setStatus("dzsd4699100110010001");
				JdbcHelper.insert(expert);
			}
		}
		return result;
	}

}
