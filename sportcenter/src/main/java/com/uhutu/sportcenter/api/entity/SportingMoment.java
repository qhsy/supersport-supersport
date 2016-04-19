package com.uhutu.sportcenter.api.entity;

import java.util.ArrayList;
import java.util.List;
import io.swagger.annotations.ApiModelProperty;

/***
 * 
 * 运动时刻
 * @author xiegj
 *
 */
public class SportingMoment {
	
	@ApiModelProperty(name="标题" ,notes="标题",example="新体优家，您运动的首选~")
	private String title="";
	
	@ApiModelProperty(name="内容" ,notes="内容",example="有一天，我和爸爸来到了操场上~~~")
	private String content="";
	
	@ApiModelProperty(name="背景图片链接" ,notes="背景图片链接",example="http://www.ichsy.com")
	private String bgProUrl="";
	
	@ApiModelProperty(name="运动标签" ,notes="运动标签",example="户外运动.滑雪")
	private List<String> sportLabels=new ArrayList<String>();
	
	@ApiModelProperty(name="日期展示" ,notes="日期展示",example="2016-4-19")
	private String dateShow="";
	
	@ApiModelProperty(name="地理位置" ,notes="位置经纬度",example="116.404, 39.915")
	private String location="";
	
	@ApiModelProperty(name="地理位置名称" ,notes="位置名称",example="金域国际大厦")
	private String locationName="";
	
	@ApiModelProperty(name="头像图片链接" ,notes="头像图片链接",example="http://www.ichsy.com")
	private String headProUrl="";
	
	@ApiModelProperty(name="昵称" ,notes="昵称",example="papi酱")
	private String nickname="";
	
	@ApiModelProperty(name="赞的数量" ,notes="赞的数量",example="8888")
	private String supportNum="";
	
	@ApiModelProperty(name="发布状态" ,notes="发布状态",example="01")
	private String status="";
	
	@ApiModelProperty(name="发布图片链接" ,notes="发布图片链接",example="http://www.ichsy.com")
	private List<String> picurls = new ArrayList<String>();
	
	@ApiModelProperty(name="发布视频链接" ,notes="发布视频链接",example="http://www.ichsy.com")
	private List<String> videos = new ArrayList<String>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBgProUrl() {
		return bgProUrl;
	}

	public void setBgProUrl(String bgProUrl) {
		this.bgProUrl = bgProUrl;
	}

	public List<String> getSportLabels() {
		return sportLabels;
	}

	public void setSportLabels(List<String> sportLabels) {
		this.sportLabels = sportLabels;
	}

	public String getDateShow() {
		return dateShow;
	}

	public void setDateShow(String dateShow) {
		this.dateShow = dateShow;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getHeadProUrl() {
		return headProUrl;
	}

	public void setHeadProUrl(String headProUrl) {
		this.headProUrl = headProUrl;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSupportNum() {
		return supportNum;
	}

	public void setSupportNum(String supportNum) {
		this.supportNum = supportNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getPicurls() {
		return picurls;
	}

	public void setPicurls(List<String> picurls) {
		this.picurls = picurls;
	}

	public List<String> getVideos() {
		return videos;
	}

	public void setVideos(List<String> videos) {
		this.videos = videos;
	}
	 	
}
