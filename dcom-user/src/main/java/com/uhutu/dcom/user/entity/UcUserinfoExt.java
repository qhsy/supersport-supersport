package com.uhutu.dcom.user.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 用户信息扩展
 * @author pang_jhui
 *
 */
@Entity
public class UcUserinfoExt extends BaseEntity {
	
	@ZooData(name="用户编号")
	private String userCode;
	
	@ZooData(name="昵称")
	private String nickName;
	
	@ZooData(name="性别")
	private String sex;
	
	@ZooData(name="位置")
	private String location;
	
	@ZooData(name="简介封面")
	private String aboutCover;
	
	@ZooData(name="简介标签")
	private String aboutTag;
	
	@ZooData(name="简介视频")
	private String aboutVideo;
	
	@ZooData(name="简介描述")
	private String aboutDesc;
	
	@ZooData(name="关注领域")
	private String domain;
	
	@ZooData(name="用户等级")
	private String level;
	
	@ZooData(name="用户头像")
	private String aboutHead;

	/**
	 * 获取用户编号
	 * @return
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * 设置用户编号
	 * @param userCode
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * 昵称
	 * @return
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * 设置昵称
	 * @param nickName
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * 获取性别
	 * @return
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 设置性别
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 获取定位
	 * @return
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * 设置定位
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * 获取简介封面
	 * @return
	 */
	public String getAboutCover() {
		return aboutCover;
	}

	/**
	 * 设置简介封面
	 * @param aboutCover
	 */
	public void setAboutCover(String aboutCover) {
		this.aboutCover = aboutCover;
	}

	/**
	 * 获取简介标签
	 * @return
	 */
	public String getAboutTag() {
		return aboutTag;
	}

	/**
	 * 设置简介标签
	 * @param aboutTag
	 */
	public void setAboutTag(String aboutTag) {
		this.aboutTag = aboutTag;
	}

	/**
	 * 获取简介视频
	 * @return
	 */
	public String getAboutVideo() {
		return aboutVideo;
	}

	/**
	 * 设置简介视频
	 * @param aboutVideo
	 */
	public void setAboutVideo(String aboutVideo) {
		this.aboutVideo = aboutVideo;
	}

	/**
	 * 获取简介描述
	 * @return
	 */
	public String getAboutDesc() {
		return aboutDesc;
	}

	/**
	 * 设置简介表述
	 * @param aboutDesc
	 */
	public void setAboutDesc(String aboutDesc) {
		this.aboutDesc = aboutDesc;
	}

	/**
	 * 获取关注领域
	 * @return
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * 设置关注领域
	 * @param domain
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * 获取用户等级
	 * @return
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * 设置用户等级
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
