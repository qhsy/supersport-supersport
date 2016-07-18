package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 翘臀大赛
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiButtockPowerListInput extends RootApiInput {
	
	@ApiModelProperty(value="当前页码")
	private int pagination;
	
	@ApiModelProperty(value="图片压缩宽度")
	private int width;

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

}
