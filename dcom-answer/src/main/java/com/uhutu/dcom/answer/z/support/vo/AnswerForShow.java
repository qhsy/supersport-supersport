package com.uhutu.dcom.answer.z.support.vo;

import com.uhutu.zoocom.root.RootClass;

import io.swagger.annotations.ApiModelProperty;

public class AnswerForShow extends RootClass {

	@ApiModelProperty(name = "用户编号")
	private String userCode;

	@ApiModelProperty(name = "用户类型")
	private String type;

	@ApiModelProperty(name = "用户昵称")
	private String nickName;

	@ApiModelProperty(name = "用户头像")
	private String headUrl;

	@ApiModelProperty(name = "用户头衔")
	private String title;

	@ApiModelProperty(name = "已回答数")
	private long answer;

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

	public long getAnswer() {
		return answer;
	}

	public void setAnswer(long answer) {
		this.answer = answer;
	}

}
