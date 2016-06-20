package com.uhutu.dcom.pay.z.request;

import com.uhutu.dcom.pay.z.face.IPayRequest;

/**
 * 微信公共请求参数
 * @author 逄小帅
 *
 */
public class WechatUnifyRequest implements IPayRequest {
	
	/*应用Id*/
	private String appid;
	
	/*商户编号*/
	private String mch_id;
	
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

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

}
