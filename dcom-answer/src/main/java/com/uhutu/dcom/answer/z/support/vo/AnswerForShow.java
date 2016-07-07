package com.uhutu.dcom.answer.z.support.vo;

import com.uhutu.zoocom.root.RootClass;

import io.swagger.annotations.ApiModelProperty;

public class AnswerForShow extends RootClass {

	@ApiModelProperty(value = "用户编号")
	private String userCode;

	@ApiModelProperty(value = "用户类型")
	private String type;

	@ApiModelProperty(value = "用户昵称")
	private String nickName;

	@ApiModelProperty(value = "用户头像")
	private String headUrl;

	@ApiModelProperty(value = "用户头衔")
	private String title;

	@ApiModelProperty(value = "已回答数")
	private int answer;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

}
