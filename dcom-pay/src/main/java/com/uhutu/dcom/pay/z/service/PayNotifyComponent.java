package com.uhutu.dcom.pay.z.service;

import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.face.IPayResponse;

/**
 * 支付通知组件
 * @author 逄小帅
 *
 */
public class PayNotifyComponent {
	
	/**
	 * 支付回调解析
	 * @param processEnum
	 * 		解析枚举
	 * @param payResponse
	 * 		支付响应信息
	 * @return 响应字符串
	 */
	public static String prase(PayProcessEnum processEnum, IPayResponse payResponse){
		
		String praseStr = "";
		
		switch (processEnum) {
		
		case WECHAT_NOTIFY:
			praseStr = praseWechatNotify(payResponse);
			break;
		case ALIPAY_NOTIFY:
			praseStr = praseAlipayNotify(payResponse);
			break;

		default:
			break;
		}
		
		return praseStr;
		
	}
	
	/**
	 * 解析微信通知返回信息
	 * @param payResponse
	 * 		微信通知响应信息
	 * @return 微信通知响应信息
	 */
	public static String praseWechatNotify(IPayResponse payResponse){
		
		String notifyStr = "";
		
		return notifyStr;
		
	}
	
	/**
	 * 解析支付宝通知返回信息
	 * @param payResponse
	 * 		支付宝通知响应信息
	 * @return 支付宝通知响应信息
	 */
	public static String praseAlipayNotify(IPayResponse payResponse){
		
		String notifyStr = "";
		
		return notifyStr;
		
	}

}
