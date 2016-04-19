package com.uhutu.sportcenter.api.entity;

import io.swagger.annotations.ApiModelProperty;

public class Label {
	
	@ApiModelProperty(name="标签编号" ,notes="标签编号",example="lb001")
	private String labelCode="";
	
	@ApiModelProperty(name="标签" ,notes="标签",example="极限运动")
	private String labelName="";

	public String getLabelCode() {
		return labelCode;
	}

	public void setLabelCode(String labelCode) {
		this.labelCode = labelCode;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	
}
