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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}
