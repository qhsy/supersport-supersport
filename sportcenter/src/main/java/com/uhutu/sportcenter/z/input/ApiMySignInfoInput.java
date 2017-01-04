package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 报名信息输入参数
 * @author 逄小帅
 *
 */
public class ApiMySignInfoInput extends RootApiInput {
	
	@ApiModelProperty(value="报名编号")
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
