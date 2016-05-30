package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 社交类软件登录处理结果
 * @author pang_jhui
 *
 */
public class ApiSocialLoginResult extends RootApiResult {
	
	@ApiModelProperty(value = "用户认证串", notes = "登陆成功后返回非空，用于需要用户授权api_token的操作")
	private String userToken = "";
	
	@ApiModelProperty(value="是否是第一次登录")
	private boolean firstLogin = false;

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public boolean isFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(boolean firstLogin) {
		this.firstLogin = firstLogin;
	}

}
