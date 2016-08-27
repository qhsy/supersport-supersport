package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户基本信息
 * @author 逄小帅
 *
 */
public class UserBasicInfo {
	
	@ApiModelProperty(value = "用户编号", notes = "用户编号")
	private String userCode = "";
	
	@ApiModelProperty(value = "昵称", notes = "昵称")
	private String nickName = "";
	
	@ApiModelProperty(value="用户类型",example = "dzsd4107100310010001:普通用户,dzsd4107100310010002:体育达人")
	private String type = "";
	
	@ApiModelProperty(value = "简介头像", notes = "简介头像")
	private String aboutHead = "";
	
	@ApiModelProperty(value="头衔")
	private String title;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAboutHead() {
		return aboutHead;
	}

	public void setAboutHead(String aboutHead) {
		this.aboutHead = aboutHead;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
