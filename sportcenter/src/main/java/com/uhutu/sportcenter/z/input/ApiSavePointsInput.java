package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

public class ApiSavePointsInput extends RootApiInput {

	@ApiModelProperty(name = "内容编号", required = true, value = "编号", example = "v1.1.0,启动startApp,注册：register,直播间编号")
	private String code;

	@ApiModelProperty(name = "积分类型", required = true, value = "积分类型", example = "积分类型:JFLXBH170519110001~07,特效类型:TXLXBH0001~03")
	private String type;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
