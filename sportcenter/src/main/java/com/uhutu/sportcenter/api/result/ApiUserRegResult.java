package com.uhutu.sportcenter.api.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户信息注册结果
 * @author pang_jhui
 *
 */
public class ApiUserRegResult extends RootApiResult {
	
	@ApiModelProperty(value = "用户编号")
	private String userCode;
	
	@ApiModelProperty(value="会话token")
	private String userToken;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	
	

}
