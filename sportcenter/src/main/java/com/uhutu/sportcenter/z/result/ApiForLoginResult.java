package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author xiegj
 * 短信验证登录输出类
 */
public class ApiForLoginResult extends RootApiResult {

	@ApiModelProperty(value = "用户认证串", notes = "登陆成功后返回非空，用于需要用户授权api_token的操作")
	private String userToken = "";

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
}
