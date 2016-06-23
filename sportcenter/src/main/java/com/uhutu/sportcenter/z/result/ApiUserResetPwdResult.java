package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;
import io.swagger.annotations.ApiModelProperty;
/**
 * 用户重置密码处理结果
 * @author pang_jhui
 *
 */

public class ApiUserResetPwdResult extends RootApiResult {
	
	@ApiModelProperty(value="会话token")
	private String userToken;
	
	@ApiModelProperty(value="用户编号")
	private String userCode;

	@ApiModelProperty(value = "sig信息")
	private String sig;
	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getSig() {
		return sig;
	}

	public void setSig(String sig) {
		this.sig = sig;
	}

}
