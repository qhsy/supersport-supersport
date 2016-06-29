package com.uhutu.sportcenter.z.result;

import com.uhutu.dcom.extend.sms.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 微信配置信息result
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiWechatConfigInfoResult extends RootApiResult {
	
	@ApiModelProperty(value="公众号的唯一标识")
	private String appId;
	
	@ApiModelProperty(value="生成签名的时间戳")
	private String timestamp;
	
	@ApiModelProperty(value="生成签名的随机串")
	private String nonceStr;
	
	@ApiModelProperty(value="签名")
	private String signature;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
