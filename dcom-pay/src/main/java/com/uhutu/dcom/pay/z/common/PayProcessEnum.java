package com.uhutu.dcom.pay.z.common;

/**
 * 支付解析枚举
 * @author 逄小帅
 *
 */
public enum PayProcessEnum {
	
	/**支付宝*/
	ALIPAY,
	/**微信*/
	WECHAT,	
	/**微信回调*/
	WECHAT_NOTIFY,	
	/**微信h5回调*/
	WECHATH5_NOTIFY,
	/**支付宝回调*/
	ALIPAY_NOTIFY,
	/**微信公众号配置信息*/
	WECHAT_SERVICE_CONFIG,
	/**微信h5支付*/
	WECHAT_H5,
	/**微信授权*/
	WECHAT_AUTH,
	/**微信授权(报名)*/
	WECHAT_SIGN_AUTH,
	/**微信用户信息*/
	WECHAT_USER,
	/**微信消息推送*/
	WECHAT_MSG,
	/**微信token*/
	WECHAT_TOKEN,
	/**微信统一下单*/
	WECHAT_ORDER,
	/**微信企业支付*/
	WECHAT_COM,
	/**微信消息提问*/
	WECHAT_MSG_ASK,
	/**微信消息回答*/
	WECHAT_MSG_ANSWER,
	/**微信消息退款*/
	WECHAT_MSG_REFUND,
	/**金币支付*/
	GOLD_COIN,
	/**crossfit*/
	WECHAT_CF,
	/**crossfit h5*/
	WECHAT_H5_CF,
	/**crossfit*/
	WECHAT_CF_NOTIFY,
	/**crossfit h5*/
	WECHAT_CFH5_NOTIFY,
	/**entry*/
	ENTRY,
	/**entry h5*/
	ENTRY_H5,
	/**entry*/
	ENTRY_NOTIFY,
	/**entry h5*/
	ENTRY_H5_NOTIFY;

}
