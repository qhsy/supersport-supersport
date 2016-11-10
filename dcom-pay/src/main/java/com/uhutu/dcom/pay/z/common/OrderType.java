package com.uhutu.dcom.pay.z.common;

import org.apache.commons.lang3.StringUtils;

/**
 * 订单类型
 * @author 逄小帅
 *
 */
public enum OrderType {
	
	/**crossfit*/
	CROSSFIT_TD("dzsd4112100110010005","2016 Beijing ThrowDown报名"),
	
	/**偷听订单*/
	ANSWER_LISTEN("dzsd4112100110010004","果冻体育-问答支付"),
	
	/**达人订单*/
	ANSWER_EXPERT("dzsd4112100110010002","果冻体育-问答支付"),
	
	/**问答订单*/
	ANSWER_QUESTION("dzsd4112100110010003","果冻体育-问答支付"),
	
	/**活动订单*/
	ANSWER_ACTIVITY("dzsd4112100110010001","果冻体育-问答支付");
	
	
	OrderType(String code, String text) {
		
		this.code = code;
		
		this.text = text;
		
	}
	
	/*订单状态*/
	private String code;
	
	/*展示文本*/
	private String text;

	public String getCode() {
		return code;
	}

	public String getText() {
		return text;
	}
	
	/**
	 * 根据编号获取文本
	 * 
	 * @param code
	 *            编码
	 * @return 文本
	 */
	public static OrderType prase(String code) {

		OrderType temp = OrderType.ANSWER_QUESTION;

		for (OrderType answerEnum : OrderType.values()) {

			if (StringUtils.equals(answerEnum.getCode(), code)) {

				temp = answerEnum;

				break;

			}

		}

		return temp;

	}



}
