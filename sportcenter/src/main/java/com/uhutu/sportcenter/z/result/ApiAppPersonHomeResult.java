package com.uhutu.sportcenter.z.result;

import com.uhutu.sportcenter.z.entity.AnswerUserInfo;
import com.uhutu.sportcenter.z.entity.UserContentTabInfo;
import com.uhutu.sportcenter.z.entity.UserQuestionTabInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 个人首页展示
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiAppPersonHomeResult extends RootApiResult {
	
	@ApiModelProperty(value="问答用户信息")
	private AnswerUserInfo answerUserInfo;
	
	@ApiModelProperty(value="是否本人")
	private boolean ownFlag = false;
	
	@ApiModelProperty(value="问题信息tab")
	private UserQuestionTabInfo userQuestionTabInfo = new UserQuestionTabInfo();
	
	@ApiModelProperty(value="运动时刻信息tab")
	private UserContentTabInfo userContentTabInfo = new UserContentTabInfo();

	public AnswerUserInfo getAnswerUserInfo() {
		return answerUserInfo;
	}

	public void setAnswerUserInfo(AnswerUserInfo answerUserInfo) {
		this.answerUserInfo = answerUserInfo;
	}

	public boolean isOwnFlag() {
		return ownFlag;
	}

	public void setOwnFlag(boolean ownFlag) {
		this.ownFlag = ownFlag;
	}

	public UserQuestionTabInfo getUserQuestionTabInfo() {
		return userQuestionTabInfo;
	}

	public void setUserQuestionTabInfo(UserQuestionTabInfo userQuestionTabInfo) {
		this.userQuestionTabInfo = userQuestionTabInfo;
	}

	public UserContentTabInfo getUserContentTabInfo() {
		return userContentTabInfo;
	}

	public void setUserContentTabInfo(UserContentTabInfo userContentTabInfo) {
		this.userContentTabInfo = userContentTabInfo;
	}
	

}
