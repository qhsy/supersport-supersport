package com.uhutu.sportcenter.z.result;

import com.uhutu.dcom.extend.sms.RootApiResult;
import com.uhutu.sportcenter.z.entity.AnswerQuestionForShow;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author xiegj
 *
 */
public class ApiAnswerQuestionDetailResult extends RootApiResult {

	@ApiModelProperty(value = "回答问题所需展示的信息")
	private AnswerQuestionForShow show = new AnswerQuestionForShow();

	public AnswerQuestionForShow getShow() {
		return show;
	}

	public void setShow(AnswerQuestionForShow show) {
		this.show = show;
	}

}
