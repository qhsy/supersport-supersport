package com.uhutu.dcom.pay.z.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 支付配置信息factory
 * @author 逄小帅
 *
 */
@Component
public class PayConfigFactory {
	
	/*支付宝配置信息*/
	@Autowired
	private AlipayConfig alipayConfig;
	
	/*微信配置信息*/
	@Autowired
	private WechatConfig wechatConfig;
	
	/*微信消息推送*/
	@Autowired
	private WechatMsgConfig wechatMsgConfig;

	/**
	 * 获取支付宝配置信息
	 * @return 支付宝信息
	 */
	public AlipayConfig getAlipayConfig() {
		return alipayConfig;
	}

	/**
	 * 获取微信支付信息
	 * @return 微信配置信息
	 */
	public WechatConfig getWechatConfig() {
		return wechatConfig;
	}

	/**
	 * 微信消息配置信息
	 * @return
	 */
	public WechatMsgConfig getWechatMsgConfig() {
		return wechatMsgConfig;
	}

}
