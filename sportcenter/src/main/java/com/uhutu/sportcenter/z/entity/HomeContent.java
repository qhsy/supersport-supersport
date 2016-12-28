package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 内容基本信息数据模型
 * 
 * @author xiegj
 *
 */
public class HomeContent {

	@ApiModelProperty(name = "内容封面图片链接", notes = "内容封面图片链接", example = "http://www.ichsy.com")
	private String cover;

	@ApiModelProperty(name = "标题", notes = "标题", example = "新体优家，您运动的首选~")
	private String title;

	@ApiModelProperty(name = "昵称")
	private String nickName;

	@ApiModelProperty(name = "跳转类")
	private JumpTypeData jump;

	public JumpTypeData getJump() {
		return jump;
	}

	public void setJump(JumpTypeData jump) {
		this.jump = jump;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
