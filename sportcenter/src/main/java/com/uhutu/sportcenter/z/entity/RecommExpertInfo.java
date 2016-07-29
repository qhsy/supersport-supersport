package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 推荐达人信息
 * @author 逄小帅
 *
 */
public class RecommExpertInfo extends UserBasicInfo {

	@ApiModelProperty(value = "头衔", notes = "头衔")
	private String title = "";

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
