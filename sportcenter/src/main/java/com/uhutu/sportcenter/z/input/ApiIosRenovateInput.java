package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ApiIosRenovateInput extends RootApiInput {

	@ApiModelProperty(name = "版本号", value = "版本号", example = "v1.1.0")
	private String version = "";

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
}
