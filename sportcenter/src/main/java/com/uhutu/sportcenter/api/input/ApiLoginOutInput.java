package com.uhutu.sportcenter.api.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author pang_jhui
 *
 */
@ApiModel
public class ApiLoginOutInput extends RootApiInput {
	
	@ApiModelProperty(value = "用户名", notes = "用户名", example = "13512345678", required = true)
	private String loginName = "";

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

}
