package com.uhutu.sportcenter.z.input;

import com.uhutu.sportcenter.z.entity.UserInfo;
import com.uhutu.zoocom.root.RootApiInput;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户信息更新输入参数
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiUpdateUserInfoInput extends RootApiInput {
	
	@ApiModelProperty(value="用户信息")
	private UserInfo userInfo;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
