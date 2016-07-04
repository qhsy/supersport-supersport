package com.uhutu.sportcenter.z.api.answer;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.support.QuestionSupport;
import com.uhutu.sportcenter.z.input.ApiNewQuestionsInput;
import com.uhutu.sportcenter.z.result.ApiNewQuestionsResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 最新问题
 * 
 * @author xiegj
 *
 */
@Component
public class ApiNewQuestions extends RootApiBase<ApiNewQuestionsInput, ApiNewQuestionsResult> {

	@Override
	protected ApiNewQuestionsResult process(ApiNewQuestionsInput input) {

		ApiNewQuestionsResult result = new ApiNewQuestionsResult();
		result.setQuestions(new QuestionSupport().getNewQuestions(input.getPage(), 20));
		return result;

	}

}
