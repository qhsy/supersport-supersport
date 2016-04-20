package com.uhutu.sportcenter.api.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 内容详细信息
 * @author pang_jhui
 *
 */
public class ContentDetailInfo {
	
	@ApiModelProperty(name="内容编号" ,notes="内容编号")
	private String content_code="";
	
	@ApiModelProperty(name="内容" ,notes="内容")
	private  byte[] content;
	
	@ApiModelProperty(name="简介",notes="简介")
	private String description = "";
	
	@ApiModelProperty(name="图片",notes="图片")
	private String picture = "";
	
	@ApiModelProperty(name="视频",notes="视频")
	private String video = "";

	public String getContent_code() {
		return content_code;
	}

	public void setContent_code(String content_code) {
		this.content_code = content_code;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

}
