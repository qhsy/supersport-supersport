package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 消息通知信息
 * @author 逄小帅
 *
 */
public class ApiAttendInfo {
	
	@ApiModelProperty(name="用户头像")
	private String headUrl;
	
	@ApiModelProperty(name="用户昵称")
	private String nickName;
	
	@ApiModelProperty(name="用户编号")
	private String userCode;

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	

}
