package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户关注列表输入参数
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiAnswerAttendListInput extends RootApiInput {
	
	@ApiModelProperty(value="页码",required=true)
	private int pagination;
	
	@ApiModelProperty(value="用户编号",required=true)
	private String userCode;

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
