package com.uhutu.sportcenter.z.api.answer;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiQuestionDetailInput;
import com.uhutu.sportcenter.z.result.ApiQuestionDetailResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 提问信息
 *
 */
@Component
public class ApiQuestionDetail extends RootApiToken<ApiQuestionDetailInput, ApiQuestionDetailResult> {

	@Override
	protected ApiQuestionDetailResult process(ApiQuestionDetailInput input) {

		ApiQuestionDetailResult result = new ApiQuestionDetailResult();

		
		return result;
	}

}
