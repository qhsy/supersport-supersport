package com.uhutu.dcom.extend.sms;

import com.uhutu.zoocom.model.MResult;

import io.swagger.annotations.ApiModelProperty;


public class RootApiResult extends MResult {

	/**
	 * 验证码
	 */
	private String verifyCode;

	/**
	 * 验证码流水号 此参数返回给客户端
	 */
	private String verifyNumber;

	/**
	 * 过期秒数
	 */
	private int expireSecond;

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getVerifyNumber() {
		return verifyNumber;
	}

	public void setVerifyNumber(String verifyNumber) {
		this.verifyNumber = verifyNumber;
	}

	public int getExpireSecond() {
		return expireSecond;
	}

	public void setExpireSecond(int expireSecond) {
		this.expireSecond = expireSecond;
	}
	
}
