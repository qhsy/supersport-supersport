package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 提问时问题信息发送
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiAskWechatMsgInput extends RootApiInput {
	
	@ApiModelProperty(value="问题编号")
	private String questionCode;

	public String getQuestionCode() {
		return questionCode;
	}

	public void setQuestionCode(String questionCode) {
		this.questionCode = questionCode;
	}

}
