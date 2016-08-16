package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 金币流水信息
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiCoinFlowInfoInput extends RootApiInput {
	
	@ApiModelProperty(name = "页码", value = "页码", example = "0")
	private int pagination = 0;

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

}
