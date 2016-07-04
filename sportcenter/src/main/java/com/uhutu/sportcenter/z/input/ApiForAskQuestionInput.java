package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 提问输入信息
 *
 */
public class ApiForAskQuestionInput extends RootApiInput {
	@ApiModelProperty(name = "问题内容", required = true)
	private String content;

	@ApiModelProperty(name = "需要回答问题者", required = true)
	private String answerUserCode;

	@ApiModelProperty(name = "分享范围", value = "dzsd4888100110020001:私密,dzsd4888100110020002:公开", required = true)
	private String scope;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswerUserCode() {
		return answerUserCode;
	}

	public void setAnswerUserCode(String answerUserCode) {
		this.answerUserCode = answerUserCode;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}