package com.uhutu.dcom.pay.z.request;

import com.uhutu.dcom.pay.z.face.IPayRequest;

/**
 * 收到回复通知请求
 * @author 逄小帅
 *
 */
public class WechatMsgRemarkRequest implements IPayRequest {
	
	/*内容提示信息*/
	private WechatMsgContent first;
	
	/*回复者*/
	private WechatMsgContent keyword1;
	
	/*回复时间*/
	private WechatMsgContent keyword2;
	
	/*回复内容*/
	private WechatMsgContent keyword3;
	
	/*消息备注*/
	private String remark;

	public WechatMsgContent getFirst() {
		return first;
	}

	public void setFirst(WechatMsgContent first) {
		this.first = first;
	}

	public WechatMsgContent getKeyword1() {
		return keyword1;
	}

	public void setKeyword1(WechatMsgContent keyword1) {
		this.keyword1 = keyword1;
	}

	public WechatMsgContent getKeyword2() {
		return keyword2;
	}

	public void setKeyword2(WechatMsgContent keyword2) {
		this.keyword2 = keyword2;
	}

	public WechatMsgContent getKeyword3() {
		return keyword3;
	}

	public void setKeyword3(WechatMsgContent keyword3) {
		this.keyword3 = keyword3;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
