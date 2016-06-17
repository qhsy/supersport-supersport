package com.uhutu.dcom.pay.z.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 微信配置信息
 * @author 逄小帅
 *
 */
@Component
public class WechatConfig {
	
	/*应用编号*/
	@Value("${wechat_appid}")
	private String appId;
	
	/*商户编号*/
	@Value("${wechat_mch_id}")
	private String mchId;
	
	/*交易类型*/
	@Value("${wechat_trade_type}")
	private String tradeType;
	
	/*微信主动通知地址*/
	@Value("${wechat_notify_url}")
	private String notifyUrl;

	/**
	 * 获取app编号
	 * @return
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * 获取商户编号
	 * @return
	 */
	public String getMchId() {
		return mchId;
	}

	/**
	 * 获取交易类型
	 * @return
	 */
	public String getTradeType() {
		return tradeType;
	}

	/**
	 * 获取微信主动通知地址
	 * @return
	 */
	public String getNotifyUrl() {
		return notifyUrl;
	}
	
	

}
