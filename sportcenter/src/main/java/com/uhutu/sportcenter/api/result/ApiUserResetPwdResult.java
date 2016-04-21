package com.uhutu.sportcenter.api.result;

import com.uhutu.zoocom.root.RootApiResult;
import io.swagger.annotations.ApiModelProperty;
/**
 * 用户重置密码处理结果
 * @author pang_jhui
 *
 */

public class ApiUserResetPwdResult extends RootApiResult {
	
	@ApiModelProperty(value="会话token")
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
