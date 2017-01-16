package com.uhutu.sportcenter.z.result;

import com.uhutu.sportcenter.z.entity.UserBasicInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 邀请用户基本信息
 * @author 逄小帅
 *
 */
public class ApiInviteUserInfoResult extends RootApiResult {
	
	@ApiModelProperty(value="用户基本信息")
	private UserBasicInfo userBasicInfo;

	public UserBasicInfo getUserBasicInfo() {
		return userBasicInfo;
	}

	public void setUserBasicInfo(UserBasicInfo userBasicInfo) {
		this.userBasicInfo = userBasicInfo;
	}

}
