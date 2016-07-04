package com.uhutu.dcom.pay.z.response;

import com.uhutu.dcom.pay.z.face.IPayResponse;

/**
 * 微信消息推送响应结果
 * @author 逄小帅
 *
 */
public class WechatMsgResponse implements IPayResponse {
	
	/*错误代码*/
	private String errcode;
	
	/*错误消息*/
	private String errmsg;
	
	/*消息id*/
	private String msgid;

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

}
