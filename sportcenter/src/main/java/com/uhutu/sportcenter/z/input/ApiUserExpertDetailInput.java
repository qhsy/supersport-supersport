package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 达人详情查询
 * @author pang_jhui
 *
 */
public class ApiUserExpertDetailInput extends RootApiInput {
	
	@ApiModelProperty(value="用户编号")
	private String userCode;
	
	@ApiModelProperty(value="当前页码")
	private int pagination;
	
	@ApiModelProperty(value="操作标识",example="share:分享")
	private String operFalg;

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

	public String getOperFalg() {
		return operFalg;
	}

	public void setOperFalg(String operFalg) {
		this.operFalg = operFalg;
	}
	
	

}
