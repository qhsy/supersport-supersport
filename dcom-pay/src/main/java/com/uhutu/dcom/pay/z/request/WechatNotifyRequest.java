package com.uhutu.dcom.pay.z.request;

import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.response.WechatUnifyResponse;

/**
 * 微信通知请求信息
 * @author 逄小帅
 *
 */
public class WechatNotifyRequest extends WechatUnifyResponse implements IPayRequest {
	
	/*公众号appid*/
	private String appid;
	
	/*商户号*/
	private String mch_id;
	
	/*随机字符串*/
	private String nonce_str;
	
	/*签名*/
	private String sign;
	
	/*业务结果*/
	private String result_code;
	
	/*错误代码*/
	private String err_code;
	
	/*错误代码描述*/
	private String err_code_des;
	
	/*用户标识*/
	private String openid;
	
	/*是否关注公众号*/
	private String is_subscribe;
	
	/*交易类型*/
	private String trade_type;
	
	/*付款银行*/
	private String bank_type;
	
	/*订单金额*/
	private int total_fee;
	
	/*现金支付金额*/
	private int cash_fee;
	
	/*微信交易流水号*/
	private String transaction_id;
	
	/*微信支付订单号*/
	private String out_trade_no;
	
	/*金额类型*/
	private String fee_type;
	
	private String sub_mch_id;
	
	/*业务处理*/
	private PayProcessEnum processType;
	
	/*支付完成时间*/
	private String time_end;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
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

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIs_subscribe() {
		return is_subscribe;
	}

	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public int getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}

	public int getCash_fee() {
		return cash_fee;
	}

	public void setCash_fee(int cash_fee) {
		this.cash_fee = cash_fee;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

	public PayProcessEnum getProcessType() {
		return processType;
	}

	public void setProcessType(PayProcessEnum processType) {
		this.processType = processType;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public String getSub_mch_id() {
		return sub_mch_id;
	}

	public void setSub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
	}
	
	

}
