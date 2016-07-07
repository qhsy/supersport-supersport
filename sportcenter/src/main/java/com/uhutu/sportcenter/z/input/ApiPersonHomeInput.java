package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 个人主页输入参数
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiPersonHomeInput extends RootApiInput {
	
	@ApiModelProperty(value="用户编号",notes="必填")
	private String userCode;
	
	@ApiModelProperty(value="当前页码")
	private int pagination;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

}
