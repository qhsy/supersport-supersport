package com.uhutu.sportcenter.z.entity;
import io.swagger.annotations.ApiModelProperty;

/**
 *内容各种评论数量实体 
 */
public class RemarkInfo {
	@ApiModelProperty(value="评论类型",example="remarkCount:评论数量,favorCount:喜欢的数量")
	private String type;
	
	@ApiModelProperty(value="数量")
	private int total;
	
	@ApiModelProperty(value="图标点亮",example="喜欢等 1:亮 0:暗")
	private String favor;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getFavor() {
		return favor;
	}

	public void setFavor(String favor) {
		this.favor = favor;
	}
	
	
}
