package com.uhutu.sportcenter.api.result;

import com.uhutu.sportcenter.api.entity.ApiUserInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户信息展示列表
 * @author pang_jhui
 *
 */
public class ApiUserInfoResult extends RootApiResult {
	
	@ApiModelProperty(value = "用户信息")
	private ApiUserInfo userInfo = new ApiUserInfo();

	public ApiUserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(ApiUserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
