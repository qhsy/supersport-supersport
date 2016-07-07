package com.uhutu.dcom.pay.z.response;

/**
 * 微信企业支付响应信息
 * @author 逄小帅
 *
 */
public class WechatComPayResponse extends WechatUnifyResponse {
	
	/*商户appid*/
	private String mch_appid;
	
	/*商户号*/
	private String mchid;
	
	/*随机字符串*/
	private String nonce_str;
	
	/*业务结果*/
	private String result_code;
	
	/*错误代码*/
	private String err_code;
	
	/*错误代码描述*/
	private String err_code_des;
	
	/*商户订单编号*/
	private String partner_trade_no;
	
	/*微信订单编号*/
	private String payment_no;
	
	/*支付成功时间*/
	private String payment_time;

	public String getMch_appid() {
		return mch_appid;
	}

	public void setMch_appid(String mch_appid) {
		this.mch_appid = mch_appid;
	}

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
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

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}

	public String getPayment_no() {
		return payment_no;
	}

	public void setPayment_no(String payment_no) {
		this.payment_no = payment_no;
	}

	public String getPayment_time() {
		return payment_time;
	}

	public void setPayment_time(String payment_time) {
		this.payment_time = payment_time;
	}

}
