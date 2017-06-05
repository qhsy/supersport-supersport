package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

public class ApiFriendsNearbyInput extends RootApiInput {

	@ApiModelProperty(value = "直播编号", required = true)
	private String code;

	@ApiModelProperty(name = "页码", value = "页码", example = "1")
	private int pagination = 1;
	
	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
