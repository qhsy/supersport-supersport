package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

public class ApiLiveMsgInput extends RootApiInput {

	@ApiModelProperty(value = "房间编号")
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
