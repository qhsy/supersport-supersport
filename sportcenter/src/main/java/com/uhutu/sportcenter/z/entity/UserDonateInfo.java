package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户捐赠信息
 * @author 逄小帅
 *
 */
public class UserDonateInfo {
	
	@ApiModelProperty(value="支持总能量值")
	private String totalPower;
	
	@ApiModelProperty(value="支持者用户昵称")
	private String nickName;
	
	@ApiModelProperty(value="支持者用户头像")
	private String headUrl;

	public String getTotalPower() {
		return totalPower;
	}

	public void setTotalPower(String totalPower) {
		this.totalPower = totalPower;
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
	
	

}
