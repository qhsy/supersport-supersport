package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 美臀大赛信息
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiButtockInfoInput extends RootApiInput {
	
	@ApiModelProperty(value="当前页码")
	private int pagination;
	
	@ApiModelProperty(value="图片压缩的宽度")
	private int width;
	
	@ApiModelProperty(value="类型",example="实力派:power,翘丽圈:lap")
	private String type;

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
