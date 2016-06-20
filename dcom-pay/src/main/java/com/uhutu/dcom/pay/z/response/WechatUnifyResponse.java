package com.uhutu.dcom.pay.z.response;

import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.zoocom.model.MResult;

/**
 * 微信公共请求参数
 * @author 逄小帅
 *
 */
public class WechatUnifyResponse extends MResult implements IPayResponse {
	
	/*应用Id*/
	private String appid;
	
	/*随机字符串*/
	private String noncestr;
	
	/*签名*/
	private String sign;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getNoncestr() {
		return noncestr;
	}

	public void setNoncestr(String noncestr) {
		this.noncestr = noncestr;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
