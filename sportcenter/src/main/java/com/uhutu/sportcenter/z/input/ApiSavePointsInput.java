package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

public class ApiSavePointsInput extends RootApiInput {

	@ApiModelProperty(name = "编号", required = true, value = "编号", example = "v1.1.0")
	private String code;

	@ApiModelProperty(name = "积分类型", required = true, value = "积分类型", example = "")
	private boolean type;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

}
