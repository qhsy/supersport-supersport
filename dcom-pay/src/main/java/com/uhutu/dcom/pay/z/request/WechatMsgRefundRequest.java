package com.uhutu.dcom.pay.z.request;

import com.uhutu.dcom.pay.z.face.IPayRequest;

/**
 * 收到回复通知请求
 * @author 逄小帅
 *
 */
public class WechatMsgRefundRequest implements IPayRequest {
	
	/*内容提示信息*/
	private WechatMsgContent first = new WechatMsgContent();
	
	/*退款原因*/
	private WechatMsgContent reason = new WechatMsgContent();
	
	/*退款金额*/
	private WechatMsgContent refund = new WechatMsgContent();
	
	/*消息备注*/
	private WechatMsgContent remark = new WechatMsgContent();

	/**
	 * 内容提示信息
	 * @return
	 */
	public WechatMsgContent getFirst() {
		return first;
	}

	/**
	 * 设置内容提示信息
	 * @param first
	 */
	public void setFirst(WechatMsgContent first) {
		this.first = first;
	}

	/**
	 * 获取退款原因
	 * @return
	 */
	public WechatMsgContent getReason() {
		return reason;
	}

	/**
	 * 设置退款原因
	 * @param reason
	 */
	public void setReason(WechatMsgContent reason) {
		this.reason = reason;
	}

	/**
	 * 获取退款金额
	 * @return
	 */
	public WechatMsgContent getRefund() {
		return refund;
	}

	/**
	 * 设置退款金额
	 * @param refund
	 */
	public void setRefund(WechatMsgContent refund) {
		this.refund = refund;
	}

	/**
	 * 获取备注信息
	 * @return
	 */
	public WechatMsgContent getRemark() {
		return remark;
	}

	/**
	 * 设置备注信息
	 * @param remark
	 */
	public void setRemark(WechatMsgContent remark) {
		this.remark = remark;
	}

	

}
