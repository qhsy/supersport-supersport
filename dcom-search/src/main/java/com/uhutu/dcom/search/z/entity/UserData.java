package com.uhutu.dcom.search.z.entity;

import io.swagger.annotations.ApiModelProperty;
/**
 * 搜索的用户数据
 * @author 逄小帅
 *
 */
public class UserData {
	
	@ApiModelProperty(value="用户编号")
	private String code;
	
	@ApiModelProperty(value="用户类型")
	private String type;
	
	@ApiModelProperty(value="用户昵称")
	private String nick_name;
	
	@ApiModelProperty(value="用户头像")
	private String about_head;
	
	@ApiModelProperty(value="用户头衔")
	private String title;
	
	@ApiModelProperty(value="关注标识")
	private boolean attendFlag = false;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getAbout_head() {
		return about_head;
	}

	public void setAbout_head(String about_head) {
		this.about_head = about_head;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean getAttendFlag() {
		return attendFlag;
	}

	public void setAttendFlag(boolean attendFlag) {
		this.attendFlag = attendFlag;
	}

}
