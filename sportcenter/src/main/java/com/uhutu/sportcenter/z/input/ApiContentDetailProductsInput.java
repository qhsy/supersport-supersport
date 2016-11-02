package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

public class ApiContentDetailProductsInput extends RootApiInput {

	@ApiModelProperty(value = "文章编号", notes = "文章编号", required = true)
	private String code;

	@ApiModelProperty(value = "图片最大宽度", notes = "图片最大宽度(次参数为空，图片不压缩)", example = "1080")
	private int width;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
