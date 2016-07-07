package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

public class ApiQuestionPraiseInput extends RootApiInput {

	@ApiModelProperty(value = "问达编号", notes = "问达编号", required = true, example = "MeiZi666")
	private String code = "";

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
