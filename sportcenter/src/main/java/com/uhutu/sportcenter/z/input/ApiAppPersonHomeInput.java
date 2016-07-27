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
public class ApiAppPersonHomeInput extends RootApiInput {
	
	@ApiModelProperty(value="用户编号",notes="必填")
	private String userCode;
	
	@ApiModelProperty(value="当前页码")
	private int pagination;
	
	@ApiModelProperty(value="类型",example="运动时刻tab:contentTab,问题信息tab:questionTab")
	private String type;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
