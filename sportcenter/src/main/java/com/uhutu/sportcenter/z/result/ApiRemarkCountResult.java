package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 评论数据返回
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiRemarkCountResult extends RootApiResult {
	
	@ApiModelProperty(value="总的数量")
	private int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
