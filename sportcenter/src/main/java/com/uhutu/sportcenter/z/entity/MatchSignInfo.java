package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 赛事报名信息
 * @author 逄小帅
 *
 */
public class MatchSignInfo {
	
	@ApiModelProperty(value="报名编号")
	private String signCode;
	
	@ApiModelProperty(value="报名标题")
	private String title;
	
	@ApiModelProperty(value="报名价格")
	private String signPrice;

	public String getSignCode() {
		return signCode;
	}

	public void setSignCode(String signCode) {
		this.signCode = signCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSignPrice() {
		return signPrice;
	}

	public void setSignPrice(String signPrice) {
		this.signPrice = signPrice;
	}
	

}
