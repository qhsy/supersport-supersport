package com.uhutu.sportcenter.api.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ApiHomePageInput extends RootApiInput {

	@ApiModelProperty(value="图片最大宽度",notes="图片最大宽度",example="1080" ,required=true)
	private String width="";

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}
	
}
