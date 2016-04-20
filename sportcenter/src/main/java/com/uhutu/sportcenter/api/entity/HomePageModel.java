package com.uhutu.sportcenter.api.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 *首页实例对象
 *
 *@author xiegj
 * 
 */
public class HomePageModel {
	
	@ApiModelProperty(name="展示类型" ,notes=" 01:展示图文，02:轮播图，	03:广告位",example="01")
	private String type="";
	
	@ApiModelProperty(name="头像图片链接" ,notes="头像图片链接",example="http://www.ichsy.com")
	private String headProUrl="";
	
	@ApiModelProperty(name="背景图片链接" ,notes="背景图片链接",example="http://www.ichsy.com")
	private String bgProUrl="";
	
	@ApiModelProperty(name="标题" ,notes="标题",example="新体优家，您运动的首选~")
	private String title="";
	
	@ApiModelProperty(name="地理位置" ,notes="位置经纬度",example="116.404, 39.915")
	private String location="";
	
	@ApiModelProperty(name="地理位置名称" ,notes="位置名称",example="金域国际大厦")
	private String locationName="";
	
	@ApiModelProperty(name="昵称" ,notes="昵称",example="papi酱")
	private String nickname="";
	
	@ApiModelProperty(name="轮播图图片url" ,notes="轮播图图片url",example="http://www.ichsy.com")
	private String carouselUrl="";
	
	@ApiModelProperty(name="轮播图链接跳转类型" ,notes="轮播图链接跳转类型01:超链接,02:运动时刻详情页,03:个人中心",example="01")
	private String carouselLinkType="";
	
	@ApiModelProperty(name="轮播图链接跳转内容" ,notes="轮播图链接跳转内容",example="http://www.ichsy.com")
	private String carouselLinkContent="";
	
	@ApiModelProperty(name="日期展示" ,notes="日期展示",example="2016-4-19")
	private String dateShow="";

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHeadProUrl() {
		return headProUrl;
	}

	public void setHeadProUrl(String headProUrl) {
		this.headProUrl = headProUrl;
	}

	public String getBgProUrl() {
		return bgProUrl;
	}

	public void setBgProUrl(String bgProUrl) {
		this.bgProUrl = bgProUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCarouselUrl() {
		return carouselUrl;
	}

	public void setCarouselUrl(String carouselUrl) {
		this.carouselUrl = carouselUrl;
	}

	public String getDateShow() {
		return dateShow;
	}

	public void setDateShow(String dateShow) {
		this.dateShow = dateShow;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getCarouselLinkType() {
		return carouselLinkType;
	}

	public void setCarouselLinkType(String carouselLinkType) {
		this.carouselLinkType = carouselLinkType;
	}

	public String getCarouselLinkContent() {
		return carouselLinkContent;
	}

	public void setCarouselLinkContent(String carouselLinkContent) {
		this.carouselLinkContent = carouselLinkContent;
	}
	
}
