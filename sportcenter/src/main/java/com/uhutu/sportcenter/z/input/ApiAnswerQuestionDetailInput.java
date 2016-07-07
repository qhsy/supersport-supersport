package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 提问时需要的个人信息数据
 * 
 * @author xiegj
 *
 */
@ApiModel
public class ApiAnswerQuestionDetailInput extends RootApiInput {

	@ApiModelProperty(value = "问题编号", required = true)
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
