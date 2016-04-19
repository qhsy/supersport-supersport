package com.uhutu.sportcenter.api.entity;

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
	private String nick_name = "";
	
	@ApiModelProperty(value = "性别", notes = "性别")
	private String sex = "";
	
	@ApiModelProperty(value = "所在地", notes = "所在地")
	private String location = "";
	
	@ApiModelProperty(value = "封面", notes = "封面")
	private String about_cover = "";
	
	@ApiModelProperty(value = "简介标签", notes = "足球、篮球、户外")
	private String about_tag = "";
	
	@ApiModelProperty(value = "简介视频", notes = "简介视频")
	private String about_vido = "";
	
	@ApiModelProperty(value = "关注领域", notes = "关注领域")
	private String domain = "";
	
	@ApiModelProperty(value = "用户等级", notes = "用户等级")
	private String level = "";
	
	@ApiModelProperty(value = "简介头像", notes = "简介头像")
	private String about_head = "";

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
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

	public String getAbout_cover() {
		return about_cover;
	}

	public void setAbout_cover(String about_cover) {
		this.about_cover = about_cover;
	}

	public String getAbout_tag() {
		return about_tag;
	}

	public void setAbout_tag(String about_tag) {
		this.about_tag = about_tag;
	}

	public String getAbout_vido() {
		return about_vido;
	}

	public void setAbout_vido(String about_vido) {
		this.about_vido = about_vido;
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

	public String getAbout_head() {
		return about_head;
	}

	public void setAbout_head(String about_head) {
		this.about_head = about_head;
	}
	

}
