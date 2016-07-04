package com.uhutu.sportcenter.z.api.answer;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.support.QuestionSupport;
import com.uhutu.sportcenter.z.input.ApiRichAnswersInput;
import com.uhutu.sportcenter.z.result.ApiRichAnswersResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 才华排行
 * 
 * @author xiegj
 *
 */
@Component
public class ApiRichAnswers extends RootApiBase<ApiRichAnswersInput, ApiRichAnswersResult> {

	@Override
	protected ApiRichAnswersResult process(ApiRichAnswersInput input) {

		ApiRichAnswersResult result = new ApiRichAnswersResult();
		result.setAnswers(new QuestionSupport().getHotAnswers(input.getPage(), 20));
		return result;
	}

}
