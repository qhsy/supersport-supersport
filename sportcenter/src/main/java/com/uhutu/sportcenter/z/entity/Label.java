package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

public class Label {

	@ApiModelProperty(name = "标签编号", notes = "标签编号", example = "lb001")
	private String code = "";

	@ApiModelProperty(name = "标签", notes = "标签", example = "极限运动")
	private String name = "";

	@ApiModelProperty(name = "创建标签用户编号")
	private String type;

	@ApiModelProperty(name = "标签类型", notes = "dzsd4124100110010001:系统，dzsd4124100110010001:用户")
	private String labelType;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLabelType() {
		return labelType;
	}

	public void setLabelType(String labelType) {
		this.labelType = labelType;
	}

}
