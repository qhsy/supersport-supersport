package com.uhutu.dcom.search.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 赛事数据
 * @author 逄小帅
 *
 */
public class MatchData {
	
	@ApiModelProperty(value="赛事编号")
	private String match_code;
	
	@ApiModelProperty(value="赛事封面")
	private String cover;
	
	@ApiModelProperty(value="赛事名称")
	private String name;
	
	@ApiModelProperty(value="用户编号")
	private String user_code;
	
	@ApiModelProperty(value="用户类型")
	private String type;
	
	@ApiModelProperty(value="用户昵称")
	private String nick_name;
	
	@ApiModelProperty(value="头像")
	private String about_head;
	
	@ApiModelProperty(value="头衔")
	private String title;

	public String getMatch_code() {
		return match_code;
	}

	public void setMatch_code(String match_code) {
		this.match_code = match_code;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
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

}
