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
	private String accountId = "";
	
	@ApiModelProperty(value = "账户类型", example = "wechat:微信、sinaWeibo:新浪微博、qq:腾讯qq", required = true)
	private String accountType = "";
	
	@ApiModelProperty(value = "账户名称", notes = "社交类app昵称", required = true)
	private String accountName = "";
	
	@ApiModelProperty(value="头像地址")
	private String aboutHead = "";
	
	@ApiModelProperty(value="平台用户标识")
	private String openid;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAboutHead() {
		return aboutHead;
	}

	public void setAboutHead(String aboutHead) {
		this.aboutHead = aboutHead;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	

}
