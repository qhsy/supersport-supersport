package com.uhutu.dcom.search.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 短视频数据
 * @author 逄小帅
 *
 */
public class VideoData {
	
	@ApiModelProperty(value="内容编号")
	private String content_code;
	
	@ApiModelProperty(value="封面")
	private String cover;
	
	@ApiModelProperty(value="内容标题")
	private String title;
	
	@ApiModelProperty(value="内容作者")
	private String author;
	
	@ApiModelProperty(value="业务类型")
	private String busi_type;
	
	@ApiModelProperty(value="内容类型")
	private String content_type;
	
	@ApiModelProperty(value="用户类型")
	private String user_type;
	
	@ApiModelProperty(value="用户昵称")
	private String nick_name;
	
	@ApiModelProperty(value="用户头衔")
	private String user_title;
	
	@ApiModelProperty(value="用户头像")
	private String about_head;

	public String getContent_code() {
		return content_code;
	}

	public void setContent_code(String content_code) {
		this.content_code = content_code;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBusi_type() {
		return busi_type;
	}

	public void setBusi_type(String busi_type) {
		this.busi_type = busi_type;
	}

	public String getContent_type() {
		return content_type;
	}

	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getUser_title() {
		return user_title;
	}

	public void setUser_title(String user_title) {
		this.user_title = user_title;
	}

	public String getAbout_head() {
		return about_head;
	}

	public void setAbout_head(String about_head) {
		this.about_head = about_head;
	}

}
