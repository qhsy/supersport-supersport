package com.uhutu.dcom.pay.z.common;

/**
 * 支付解析枚举
 * @author 逄小帅
 *
 */
public enum PayProcessEnum {
	
	/*支付宝*/
	ALIPAY,
	/*微信*/
	WECHAT,	
	/*微信回调*/
	WECHAT_NOTIFY,	
	/*支付宝回调*/
	ALIPAY_NOTIFY,
	/*微信公众号配置信息*/
	WECHAT_SERVICE_CONFIG,
	/*微信h5支付*/
	WECHAT_H5;

}
