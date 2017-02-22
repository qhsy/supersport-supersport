package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 输入参数
 * @author 逄小帅
 *
 */
public class ApiChangeStatusInput extends RootApiInput {
	
	@ApiModelProperty(value="主播用户编号")
	private String userCode;
	
	@ApiModelProperty(value="0:上线 1:下线")
	private int status;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
