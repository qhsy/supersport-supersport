package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户分享信息
 * @author 逄小帅
 *
 */

@ApiModel
public class ApiUserShareInfoInput extends RootApiInput {
	
	@ApiModelProperty(value="用户编号")
	private String userCode;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
