package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author xiegj 短信验证登录输出类
 */
public class ApiForLoginResult extends RootApiResult {

	@ApiModelProperty(value = "用户认证串", notes = "登陆成功后返回非空，用于需要用户授权api_token的操作")
	private String userToken = "";

	@ApiModelProperty(value = "用户编号")
	private String userCode;

	@ApiModelProperty(value = "sig信息")
	private String sig;

	@ApiModelProperty(value = "是否马甲", notes="dzsd4699100110010001:是,dzsd4699100110010002:否")
	private String mjFlag;
	
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

	public String getMjFlag() {
		return mjFlag;
	}

	public void setMjFlag(String mjFlag) {
		this.mjFlag = mjFlag;
	}

}
