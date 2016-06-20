package com.uhutu.dcom.pay.z.response;

/**
 * 微信错误处理结果
 * @author 逄小帅
 *
 */
public class WechatResponse extends WechatUnifyResponse{
	
	/*应用Id*/
	private String appid;
	
	/*随机字符串*/
	private String noncestr;
	
	/*签名*/
	private String sign;
	
	/*商户编号*/
	private String mch_id;
	
	/*错误代码*/
	private String err_code;
	
	/*错误代码描述*/
	private String err_code_des;
	
	/*业务处理结果*/
	private String result_code;

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

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

}
