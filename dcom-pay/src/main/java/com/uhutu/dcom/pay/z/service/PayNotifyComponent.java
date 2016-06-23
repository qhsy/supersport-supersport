package com.uhutu.dcom.pay.z.service;

import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.response.AlipayNotifyResponse;
import com.uhutu.dcom.pay.z.response.WechatNotifyResponse;
import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.dcom.pay.z.util.XmlUtil;
import com.uhutu.zoocom.model.MDataMap;

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
		
		if(payResponse instanceof WechatNotifyResponse){
			
			WechatNotifyResponse notifyResponse = (WechatNotifyResponse) payResponse;
			
			try {
				
				MDataMap dataMap = BeanComponent.getInstance().objectToMap(notifyResponse, null, false);
				
				notifyStr = XmlUtil.getInstance().mDataMapToXml(dataMap);
				
				
				
			} catch (Exception e) {
				
				notifyStr = e.getMessage();
				
			}
			
		}
		
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
		
		if(payResponse instanceof AlipayNotifyResponse){
			
			AlipayNotifyResponse notifyResponse = (AlipayNotifyResponse) payResponse;
			
			if(notifyResponse.upFlagTrue()){
				
				notifyStr = Boolean.TRUE.toString();
				
			}
			
		}
		
		return notifyStr;
		
	}

}
