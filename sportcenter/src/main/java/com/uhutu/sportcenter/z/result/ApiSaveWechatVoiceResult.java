package com.uhutu.sportcenter.z.result;

import com.uhutu.sportcenter.z.entity.AnswerUserInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 问答用户信息
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiSaveWechatVoiceResult extends RootApiResult {
	
	@ApiModelProperty(value="问答用户信息")
	private AnswerUserInfo answerUserInfo;

	public AnswerUserInfo getAnswerUserInfo() {
		return answerUserInfo;
	}

	public void setAnswerUserInfo(AnswerUserInfo answerUserInfo) {
		this.answerUserInfo = answerUserInfo;
	}

}
