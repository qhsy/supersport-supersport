package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 社交类网站登录输入参数
 * @author pang_jhui
 *
 */
@ApiModel
public class ApiSocialLoginInput extends RootApiInput {
	
	@ApiModelProperty(value = "用户标识", notes = "用户标识", required = true)
	private String account_id = "";
	
	@ApiModelProperty(value = "账户类型", notes = "wechat:微信、sinaWeibo:新浪微博、qq:腾讯qq", required = true)
	private String account_type = "";
	
	@ApiModelProperty(value = "账户名称", notes = "社交类app昵称", required = true)
	private String account_name = "";

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

}
