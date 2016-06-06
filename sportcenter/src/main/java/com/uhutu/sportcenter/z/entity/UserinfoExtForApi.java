package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户信息扩展
 * 
 * @author pang_jhui
 *
 */

public class UserinfoExtForApi extends UserBasicInfo {

	@ApiModelProperty(name = "性别")
	private String sex;

	@ApiModelProperty(name = "位置")
	private String location;

	@ApiModelProperty(name = "简介封面")
	private String aboutCover;

	@ApiModelProperty(name = "简介标签")
	private String aboutTag;

	@ApiModelProperty(name = "简介视频")
	private String aboutVideo;

	@ApiModelProperty(name = "简介描述")
	private String aboutDesc;

	@ApiModelProperty(name = "关注领域")
	private String domain;

	@ApiModelProperty(name = "用户等级")
	private String level;
	
	/**
	 * 获取性别
	 * 
	 * @return
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 设置性别
	 * 
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 获取定位
	 * 
	 * @return
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * 设置定位
	 * 
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * 获取简介封面
	 * 
	 * @return
	 */
	public String getAboutCover() {
		return aboutCover;
	}

	/**
	 * 设置简介封面
	 * 
	 * @param aboutCover
	 */
	public void setAboutCover(String aboutCover) {
		this.aboutCover = aboutCover;
	}

	/**
	 * 获取简介标签
	 * 
	 * @return
	 */
	public String getAboutTag() {
		return aboutTag;
	}

	/**
	 * 设置简介标签
	 * 
	 * @param aboutTag
	 */
	public void setAboutTag(String aboutTag) {
		this.aboutTag = aboutTag;
	}

	/**
	 * 获取简介视频
	 * 
	 * @return
	 */
	public String getAboutVideo() {
		return aboutVideo;
	}

	/**
	 * 设置简介视频
	 * 
	 * @param aboutVideo
	 */
	public void setAboutVideo(String aboutVideo) {
		this.aboutVideo = aboutVideo;
	}

	/**
	 * 获取简介描述
	 * 
	 * @return
	 */
	public String getAboutDesc() {
		return aboutDesc;
	}

	/**
	 * 设置简介表述
	 * 
	 * @param aboutDesc
	 */
	public void setAboutDesc(String aboutDesc) {
		this.aboutDesc = aboutDesc;
	}

	/**
	 * 获取关注领域
	 * 
	 * @return
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * 设置关注领域
	 * 
	 * @param domain
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * 获取用户等级
	 * 
	 * @return
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * 设置用户等级
	 * 
	 * @param level
	 */
	public void setLevel(String level) {
		this.level = level;
	}

}
