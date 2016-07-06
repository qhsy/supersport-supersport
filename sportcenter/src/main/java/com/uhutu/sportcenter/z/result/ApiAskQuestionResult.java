package com.uhutu.sportcenter.z.result;

import com.uhutu.dcom.extend.sms.RootApiResult;
import com.uhutu.sportcenter.z.entity.AskQuestionForShow;

import io.swagger.annotations.ApiModelProperty;

/**
 * 提问时需要的个人信息数据
 * 
 * @author xiegj
 *
 */
public class ApiAskQuestionResult extends RootApiResult {

	@ApiModelProperty(value = "问答信息列表")
	private AskQuestionForShow show = new AskQuestionForShow();

	public AskQuestionForShow getShow() {
		return show;
	}

	public void setShow(AskQuestionForShow show) {
		this.show = show;
	}

}
