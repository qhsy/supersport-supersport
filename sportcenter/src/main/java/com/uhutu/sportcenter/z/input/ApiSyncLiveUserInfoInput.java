package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 同步用户输入参数
 * @author 逄小帅
 *
 */
public class ApiSyncLiveUserInfoInput extends RootApiInput {
	
	@ApiModelProperty(value="用户编号列表,多个以逗号分割")
	private String userCodes;

	public String getUserCodes() {
		return userCodes;
	}

	public void setUserCodes(String userCodes) {
		this.userCodes = userCodes;
	}

}
