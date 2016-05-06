package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ApiHomePageInput extends RootApiInput {

	@ApiModelProperty(value = "图片最大宽度", notes = "图片最大宽度", example = "1080", required = true)
	private String width = "";

	@ApiModelProperty(value = "展示的页数", notes = "展示的页数", example = "1", required = true)
	private int pagination = 1;

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

}
