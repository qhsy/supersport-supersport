package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 赛事信息
 * @author 逄小帅
 *
 */
public class MatchDetailInfo {
	
	@ApiModelProperty(value="图片地址")
	private String imageUrl;
	
	@ApiModelProperty(value="图片宽高",example = "800*600")
	private String imageWh;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageWh() {
		return imageWh;
	}

	public void setImageWh(String imageWh) {
		this.imageWh = imageWh;
	}
	
	

}
