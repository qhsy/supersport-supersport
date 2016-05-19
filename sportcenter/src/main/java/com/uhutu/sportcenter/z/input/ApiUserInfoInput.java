package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户信息展示输入参数
 * @author pang_jhui
 *
 */
@ApiModel
public class ApiUserInfoInput extends RootApiInput {
	
	@ApiModelProperty(value = "用户编号", notes = "用户编号", required = true)
	private String userCode = "";
	
	@ApiModelProperty(name="页码",value="页码",example="0")
	private int  pagination= 0;
	
	@ApiModelProperty(value="是否本身用户",example="own:用户本身,other:非自身")
	private String operFlag;

	/**
	 * 获取用户编号
	 * @return
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * 设置用户编号
	 * @param userCode
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

	public String getOperFlag() {
		return operFlag;
	}

	public void setOperFlag(String operFlag) {
		this.operFlag = operFlag;
	}

}
