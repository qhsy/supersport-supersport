package com.uhutu.dcom.pay.z.request;

import com.uhutu.dcom.pay.z.face.IPayRequest;

/**
 * 收到回复通知请求
 * @author 逄小帅
 *
 */
public class WechatMsgAskRequest implements IPayRequest {
	
	/*内容提示信息*/
	private WechatMsgContent first = new WechatMsgContent();
	
	/*问题内容*/
	private WechatMsgContent keyword1 = new WechatMsgContent();
	
	/*问题类型*/
	private WechatMsgContent keyword2 = new WechatMsgContent();
	
	/*发生时间*/
	private WechatMsgContent keyword3 = new WechatMsgContent();
	
	/*消息备注*/
	private WechatMsgContent remark = new WechatMsgContent();

	/**
	 * 获取内容提示信息
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
	 * 获取问题内容
	 * @return
	 */
	public WechatMsgContent getKeyword1() {
		return keyword1;
	}

	/**
	 * 设置问题内容
	 * @param keyword1
	 */
	public void setKeyword1(WechatMsgContent keyword1) {
		this.keyword1 = keyword1;
	}

	/**
	 * 获取问题类型
	 * @return
	 */
	public WechatMsgContent getKeyword2() {
		return keyword2;
	}

	/**
	 * 设置问题类型
	 * @param keyword2
	 */
	public void setKeyword2(WechatMsgContent keyword2) {
		this.keyword2 = keyword2;
	}

	/**
	 * 获取发生时间
	 * @return
	 */
	public WechatMsgContent getKeyword3() {
		return keyword3;
	}

	/**
	 * 设置发生时间
	 * @param keyword3
	 */
	public void setKeyword3(WechatMsgContent keyword3) {
		this.keyword3 = keyword3;
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
