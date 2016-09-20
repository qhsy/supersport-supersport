package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 内容展示基本信息
 * @author 逄小帅
 *
 */
public class ContentShowInfo{
	
	@ApiModelProperty(value="内容封面")
	private String cover;
	
	@ApiModelProperty(value="内容标题")
	private String title;
	
	@ApiModelProperty(value="内容编号")
	private String code;
	
	@ApiModelProperty(value="内容类型")
	private String type;
	
	@ApiModelProperty(value="阅读数")
	private int readNum;

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

	public int getReadNum() {
		return readNum;
	}

	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}

}
