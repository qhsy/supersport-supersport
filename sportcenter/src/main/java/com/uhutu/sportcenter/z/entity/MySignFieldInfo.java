package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 报名字段信息
 * @author 逄小帅
 *
 */
public class MySignFieldInfo {
	
	@ApiModelProperty(value="字段名称")
	private String name;
	
	@ApiModelProperty(value="字段文本")
	private String text;
	
	@ApiModelProperty(value="字段值")
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
