package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 问题详情信息
 *
 */
public class ApiQuestionDetailInput extends RootApiInput {
	@ApiModelProperty(value = "问题编号", required = true)
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}