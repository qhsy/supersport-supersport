package com.uhutu.sportcenter.api.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 内容图集详情
 * @author pang_jhui
 *
 */
public class ContentPhotosDetail {
	
	@ApiModelProperty(value="内容编号",notes="内容编号")
	private String content_code = "";
	
	@ApiModelProperty(value="图片信息",notes="图片信息")
	private String picture = "";
	
	@ApiModelProperty(value="内容信息",notes="内容信息")
	private String content = "";

	public String getContent_code() {
		return content_code;
	}

	public void setContent_code(String content_code) {
		this.content_code = content_code;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
