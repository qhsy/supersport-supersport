package com.uhutu.sportcenter.z.entity;
/**
 *内容各种评论数量实体 
 */
import io.swagger.annotations.ApiModelProperty;

public class RemarkInfo {
	@ApiModelProperty(value="评论类型",example="remarkCount:评论数量,favorCoun:喜欢的数量")
	private String type;
	
	@ApiModelProperty(value="数量")
	private int total;

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
	
	
}
