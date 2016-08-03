package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ApiThemePageInput extends RootApiInput {

	@ApiModelProperty(value = "图片最大宽度", notes = "图片最大宽度(次参数为空，图片不压缩)", example = "1080", required = true)
	private String width = "";

	@ApiModelProperty(value = "专题编号", notes = "专题编号", example = "ZTBH001", required = true)
	private String code = "";

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

}
