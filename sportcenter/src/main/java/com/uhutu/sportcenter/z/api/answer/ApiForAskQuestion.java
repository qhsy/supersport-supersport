package com.uhutu.sportcenter.z.api.answer;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.sportcenter.z.input.ApiForAskQuestionInput;
import com.uhutu.sportcenter.z.result.ApiForAskQuestionResult;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;

/**
 * 提问信息
 *
 */
@Component
public class ApiForAskQuestion extends RootApiToken<ApiForAskQuestionInput, ApiForAskQuestionResult> {

	@Override
	protected ApiForAskQuestionResult process(ApiForAskQuestionInput input) {

		ApiForAskQuestionResult result = new ApiForAskQuestionResult();
		AwQuestionInfo qtInfo = new AwQuestionInfo();
		AwAnswerExpert answerExpert = JdbcHelper.queryOne(AwAnswerExpert.class, "userCode", input.getAnswerUserCode());
		if (answerExpert != null && "dzsd4699100110010001".equals(answerExpert.getStatus())) {
			qtInfo.setAnswerUserCode(input.getAnswerUserCode());
			qtInfo.setContent(input.getContent());
			qtInfo.setScope(input.getScope());
			qtInfo.setStatus("dzsd4888100110010001");
			qtInfo.setSellMoney(BigDecimal.valueOf(1));
			qtInfo.setQuestionUserCode(upUserCode());
			qtInfo.setQuestionTime(DateHelper.upNow());
			qtInfo.setMoney(answerExpert.getCharge());
			qtInfo.setCode(WebHelper.upCode("WDBH"));
			JdbcHelper.insert(qtInfo);
		} else {
			result.inError(88880007);
		}
		return result;
	}

}
