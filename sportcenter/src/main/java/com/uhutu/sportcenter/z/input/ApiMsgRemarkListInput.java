package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户消息中心评论列表input
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiMsgRemarkListInput extends RootApiInput {
	
	@ApiModelProperty(value="页码",example="从1开始")
	private int pagination = 1;

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

}
