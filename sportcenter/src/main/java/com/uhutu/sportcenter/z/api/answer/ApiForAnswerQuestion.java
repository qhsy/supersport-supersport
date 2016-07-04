package com.uhutu.sportcenter.z.api.answer;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.sportcenter.z.input.ApiForAnswerQuestionInput;
import com.uhutu.sportcenter.z.result.ApiForAnswerQuestionResult;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 回答问达信息
 *
 */
@Component
public class ApiForAnswerQuestion extends RootApiToken<ApiForAnswerQuestionInput, ApiForAnswerQuestionResult> {

	@Override
	protected ApiForAnswerQuestionResult process(ApiForAnswerQuestionInput input) {

		ApiForAnswerQuestionResult result = new ApiForAnswerQuestionResult();
		AwQuestionInfo qtInfo = new AwQuestionInfo();
		qtInfo.setAnswerTime(DateHelper.upNow());
		qtInfo.setCode(input.getCode());
		if (input.isRefuse()) {
			qtInfo.setStatus("dzsd4888100110010003");
		} else {
			qtInfo.setStatus("dzsd4888100110010002");
			qtInfo.setLengh(input.getLengh());
			qtInfo.setUrl(input.getUrl());
		}
		JdbcHelper.update(qtInfo, "status,length,url", "code");
		return result;
	}

}
