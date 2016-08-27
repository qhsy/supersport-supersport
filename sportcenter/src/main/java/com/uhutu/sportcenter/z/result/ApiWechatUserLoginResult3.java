package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiWechatUserLoginResult3 extends RootApiResult {
	
	@ApiModelProperty(value="系统会话")
	private String userToken;
	
	@ApiModelProperty(value="用户编号")
	private String userCode;

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
	
	

}
