package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 赛事直播信息
 * @author 逄小帅
 *
 */
public class MatchVidoInfo {
	
	@ApiModelProperty(value="内容编号")
	private String contentCode;
	
	@ApiModelProperty(value="赛事编号")
	private String matchCode;
	
	@ApiModelProperty(value="封面")
	private String cover;
	
	@ApiModelProperty(value="标题")
	private String title;
	
	@ApiModelProperty(value="作者")
	private UserBasicInfo userBasicInfo = new UserBasicInfo();

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMatchCode() {
		return matchCode;
	}

	public void setMatchCode(String matchCode) {
		this.matchCode = matchCode;
	}

	public UserBasicInfo getUserBasicInfo() {
		return userBasicInfo;
	}

	public void setUserBasicInfo(UserBasicInfo userBasicInfo) {
		this.userBasicInfo = userBasicInfo;
	}
	
	
}
