package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户展示信息
 * @author pang_jhui
 *
 */
public class UserInfo {
	
	@ApiModelProperty(value = "用户编号", notes = "用户编号")
	private String userCode = "";
	
	@ApiModelProperty(value = "昵称", notes = "昵称")
	private String nickName = "";
	
	@ApiModelProperty(value = "性别", notes = "性别")
	private String sex = "";
	
	@ApiModelProperty(value = "所在地", notes = "所在地")
	private String location = "";
	
	@ApiModelProperty(value="位置名称")
	private String locationName;
	
	@ApiModelProperty(value = "封面", notes = "封面")
	private String aboutCover = "";
	
	@ApiModelProperty(value = "简介标签", notes = "足球、篮球、户外")
	private String aboutTag = "";
	
	@ApiModelProperty(value = "简介标签展示名称", notes = "足球、篮球、户外")
	private String aboutTagName = "";
	
	@ApiModelProperty(value = "简介视频", notes = "简介视频")
	private String aboutVideo = "";
	
	@ApiModelProperty(value = "简介视频封面", notes = "简介视频封面")
	private String aboutVideoCover = "";
	
	@ApiModelProperty(value = "关注领域", notes = "关注领域集合")
	private String domain = "";
	
	@ApiModelProperty(value = "关注领域", notes = "关注领域名称集合")
	private String domainName = "";
	
	@ApiModelProperty(value = "用户等级", notes = "用户等级")
	private String level = "";
	
	@ApiModelProperty(value = "简介头像", notes = "简介头像")
	private String aboutHead = "";
	
	@ApiModelProperty(value="用户简介")
	private String aboutDesc;

	@ApiModelProperty(value = "注册到现在为止年数", notes = "注册到现在为止年数")
	private int years = 1;
	
	@ApiModelProperty(value = "运动时刻发布总数量", notes = "运动时刻数量")
	private int sportsNum = 0;
	
	@ApiModelProperty(value="粉丝数量",notes="粉丝数量")
	private int fansNum;
	
	@ApiModelProperty(value="关注数量",notes="关注数量")
	private int attendNum;
	
	@ApiModelProperty(value="喜欢数量",notes="喜欢数量")
	private int favorNum;
	
	@ApiModelProperty(value="用户操作标识",notes="社交类用户:social,普通用户:custom")
	private String socialFlag;
	

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAboutCover() {
		return aboutCover;
	}

	public void setAboutCover(String aboutCover) {
		this.aboutCover = aboutCover;
	}

	public String getAboutTag() {
		return aboutTag;
	}

	public void setAboutTag(String aboutTag) {
		this.aboutTag = aboutTag;
	}

	public String getAboutVideo() {
		return aboutVideo;
	}

	public void setAboutVideo(String aboutVideo) {
		this.aboutVideo = aboutVideo;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getAboutHead() {
		return aboutHead;
	}

	public void setAboutHead(String aboutHead) {
		this.aboutHead = aboutHead;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public int getSportsNum() {
		return sportsNum;
	}

	public void setSportsNum(int sportsNum) {
		this.sportsNum = sportsNum;
	}

	public int getFansNum() {
		return fansNum;
	}

	public void setFansNum(int fansNum) {
		this.fansNum = fansNum;
	}

	public int getAttendNum() {
		return attendNum;
	}

	public void setAttendNum(int attendNum) {
		this.attendNum = attendNum;
	}

	public String getAboutDesc() {
		return aboutDesc;
	}

	public void setAboutDesc(String aboutDesc) {
		this.aboutDesc = aboutDesc;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getAboutTagName() {
		return aboutTagName;
	}

	public void setAboutTagName(String aboutTagName) {
		this.aboutTagName = aboutTagName;
	}

	public int getFavorNum() {
		return favorNum;
	}

	public void setFavorNum(int favorNum) {
		this.favorNum = favorNum;
	}

	public String getSocialFlag() {
		return socialFlag;
	}

	public void setSocialFlag(String socialFlag) {
		this.socialFlag = socialFlag;
	}

	public String getAboutVideoCover() {
		return aboutVideoCover;
	}

	public void setAboutVideoCover(String aboutVideoCover) {
		this.aboutVideoCover = aboutVideoCover;
	}
	

}
