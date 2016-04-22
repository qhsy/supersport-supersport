package com.uhutu.sportcenter.api.entity;

import javax.persistence.Entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户信息扩展
 * 
 * @author pang_jhui
 *
 */
@Entity
public class UserinfoExtForApi {

	@ApiModelProperty(name = "用户编号")
	private String userCode;

	@ApiModelProperty(name = "昵称", notes = "昵称", example = "papi酱")
	private String nickName;

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

	@ApiModelProperty(name = "头像图片链接", notes = "头像图片链接", example = "http://www.ichsy.com")
	private String aboutHead;

	/**
	 * 获取用户编号
	 * 
	 * @return
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * 设置用户编号
	 * 
	 * @param userCode
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * 昵称
	 * 
	 * @return
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * 设置昵称
	 * 
	 * @param nickName
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

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

	public String getAboutHead() {
		return aboutHead;
	}

	public void setAboutHead(String aboutHead) {
		this.aboutHead = aboutHead;
	}

}
