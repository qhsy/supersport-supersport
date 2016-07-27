package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 绑定结算账户信息
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiBindSettleAccountInput extends RootApiInput {
	
	@ApiModelProperty(value="appid")
	private String appid;
	
	@ApiModelProperty(value="unionid")
	private String unionid;
	
	@ApiModelProperty(value="openid")
	private String openid;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

}
