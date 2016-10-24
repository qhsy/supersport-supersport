package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

public class ApiContentDetailProductsInput extends RootApiInput {

	@ApiModelProperty(value = "文章编号", notes = "文章编号", required = true)
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
