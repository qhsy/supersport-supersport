package com.uhutu.sportcenter.z.api.answer;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.support.QuestionSupport;
import com.uhutu.sportcenter.z.input.ApiHotQuestionsInput;
import com.uhutu.sportcenter.z.result.ApiHotQuestionsResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 热门问题
 * 
 * @author xiegj
 *
 */
@Component
public class ApiHotQuestions extends RootApiBase<ApiHotQuestionsInput, ApiHotQuestionsResult> {

	@Override
	protected ApiHotQuestionsResult process(ApiHotQuestionsInput input) {

		ApiHotQuestionsResult result = new ApiHotQuestionsResult();
		result.setQuestions(new QuestionSupport().getHotQuestions(input.getPage(), 20));
		return result;

	}

}
