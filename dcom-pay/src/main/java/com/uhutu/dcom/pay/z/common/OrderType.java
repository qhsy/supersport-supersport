package com.uhutu.dcom.pay.z.common;

import org.apache.commons.lang3.StringUtils;

/**
 * 订单类型
 * @author 逄小帅
 *
 */
public enum OrderType {
	
	ENTRY("dzsd4112100110010006","报名费用"),
	
	/**crossfit*/
	CROSSFIT_TD("dzsd4112100110010005","2016 Beijing ThrowDown报名"),
	
	/**偷听订单*/
	ANSWER_LISTEN("dzsd4112100110010004","果冻体育-问答支付"),
	
	/**达人订单*/
	ANSWER_EXPERT("dzsd4112100110010002","果冻体育-问答支付"),
	
	/**问答订单*/
	ANSWER_QUESTION("dzsd4112100110010003","果冻体育-问答支付"),
	
	/**活动订单*/
	ANSWER_ACTIVITY("dzsd4112100110010001","果冻体育-问答支付"),
	
	SOURCE_H5("dzsd4112100110020002","H5订单"),
	
	SOURCE_APP("dzsd4112100110020001","app订单"),
	
	CROSSFIT_H5("dzsd4112100110020002-dzsd4112100110010005","crossfit H5 订单"),
	
	CROSSFIT_APP("dzsd4112100110020001-dzsd4112100110010005","crossfit app订单"),
	
	ENTRY_H5("dzsd4112100110020002-dzsd4112100110010006","crossfit H5 订单"),
	
	ENTRY_APP("dzsd4112100110020001-dzsd4112100110010006","crossfit app订单");
	
	
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
