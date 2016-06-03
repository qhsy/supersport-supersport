package com.uhutu.sportcenter.z.entity;

import com.uhutu.zooweb.io.ImageThumb;
import io.swagger.annotations.ApiModelProperty;

/**
 * 内容图集详情
 * @author pang_jhui
 *
 */
public class ContentPhotosDetail {
	
	@ApiModelProperty(value="内容编号",notes="内容编号")
	private String contentCode = "";
	
	@ApiModelProperty(value="图片信息",notes="图片信息")
	private String picture = "";
	
	@ApiModelProperty(value="缩略图信息")
	private ImageThumb thumb;
	
	@ApiModelProperty(value="内容信息",notes="内容信息")
	private String content = "";

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
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

	public ImageThumb getThumb() {
		return thumb;
	}

	public void setThumb(ImageThumb thumb) {
		this.thumb = thumb;
	}

}
