package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户能量分享input
 * @author pang_jhui
 *
 */
public class ApiUserPowerShareInput extends RootApiInput {
	
	@ApiModelProperty(value="用户编号")
	private String userCode;
	
	@ApiModelProperty(value="分享地址")
	private String serverIp;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	
	

}
