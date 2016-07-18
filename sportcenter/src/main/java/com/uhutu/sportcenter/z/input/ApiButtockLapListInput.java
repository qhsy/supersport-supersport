package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 翘臀大赛-翘丽圈
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiButtockLapListInput extends RootApiInput {
	
	@ApiModelProperty(value="当前页码")
	private int pagination;

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

}
