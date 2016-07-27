package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 我发布的运动时刻
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiOwnSportMomentInput extends RootApiInput {
	
	@ApiModelProperty(name="页码",value="页码",example="0")
	private int pagination= 0;
	
	@ApiModelProperty(value="压缩宽度")
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
