package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

public class ApiRefreshCrossfitInput extends RootApiInput {
	
	@ApiModelProperty(value="参赛类型")
	private String type = "";

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
