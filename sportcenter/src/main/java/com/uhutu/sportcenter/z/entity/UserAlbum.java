package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户相册
 * @author 逄小帅
 *
 */
public class UserAlbum {
	
	@ApiModelProperty(value="图片地址")
	private String picture;
	
	@ApiModelProperty(value="原始图片宽度")
	private int width;
	
	@ApiModelProperty(value="原始图片高度")
	private int height;
	
	@ApiModelProperty(value="缩略图")
	private String iconUrl;

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

}
