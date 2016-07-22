package com.uhutu.sportcenter.z.result;

import com.uhutu.sportcenter.z.entity.AnswerUserInfo;
import com.uhutu.sportcenter.z.entity.UserInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户信息集合
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiUserInfoAllResult extends RootApiResult {
	
	@ApiModelProperty(value="问答用户信息")
	private AnswerUserInfo answerUserInfo;
	
	@ApiModelProperty(value="用户基本信息")
	private UserInfo userInfo;

	public AnswerUserInfo getAnswerUserInfo() {
		return answerUserInfo;
	}

	public void setAnswerUserInfo(AnswerUserInfo answerUserInfo) {
		this.answerUserInfo = answerUserInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}



}
