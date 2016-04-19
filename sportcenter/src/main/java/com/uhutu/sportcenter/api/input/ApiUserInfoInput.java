package com.uhutu.sportcenter.api.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户信息展示输入参数
 * @author pang_jhui
 *
 */
@ApiModel
public class ApiUserInfoInput extends RootApiInput {
	
	@ApiModelProperty(value = "用户编号", notes = "用户编号", required = true)
	private String userCode = "";

	/**
	 * 获取用户编号
	 * @return
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * 设置用户编号
	 * @param userCode
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
