package com.uhutu.sportcenter.api.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class APiStartPageResult extends RootApiResult {
	
	@ApiModelProperty(value = "线上域名", notes = "此参数一般为空，当域名变化时此参数不为空", example = "www.ichsy.com")
	private String website = "";

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
}