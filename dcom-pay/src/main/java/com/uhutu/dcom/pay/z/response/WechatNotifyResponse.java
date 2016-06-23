package com.uhutu.dcom.pay.z.response;

import com.uhutu.dcom.pay.z.face.IPayResponse;

/**
 * 微信支付回调响应信息
 * @author 逄小帅
 *
 */
public class WechatNotifyResponse implements IPayResponse {
	
	/*返回状态码*/
	private String return_code;
	
	/*返回信息*/
	private String return_msg;

	/**
	 * 返回状态码
	 * @return
	 */
	public String getReturn_code() {
		return return_code;
	}

	/**
	 * 设置返回状态码
	 * @param return_code
	 */
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	/**
	 * 获取返回信息
	 * @return
	 */
	public String getReturn_msg() {
		return return_msg;
	}

	/**
	 * 设置返回信息
	 * @param return_msg
	 */
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

}
