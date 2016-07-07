package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

public class ApiSportingMomentsInput extends RootApiInput {

	@ApiModelProperty(name = "查询类型", required = true, value = "查询类型1：全部。2：我关注的人，3：GODO达人", example = "1")
	private String type = "1";

	@ApiModelProperty(name = "页码", value = "页码", example = "0")
	private int pagination = 0;

	@ApiModelProperty(value = "宽度")
	private int width;

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
