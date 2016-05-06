package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 内容详细信息
 * @author pang_jhui
 *
 */
public class ContentDetailInfo {
	
	@ApiModelProperty(name="内容编号" ,notes="内容编号")
	private String code="";
	
	@ApiModelProperty(name="内容" ,notes="内容")
	private String content;
	
	@ApiModelProperty(name="简介",notes="简介")
	private String description = "";

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
