package com.uhutu.dcom.pay.z.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.pay.z.common.Constants;
import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.dcom.pay.z.util.MD5;
import com.uhutu.zoocom.helper.SecrurityHelper;
import com.uhutu.zoocom.model.MDataMap;

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
	
	/*统一下单接口地址*/
	@Value("${unifiedorder_url}")
	private String orderUrl;
	
	/*签名key*/
	@Value("${wechat_sign_key}")
	private String signKey;
	
	/*服务号appid*/
	@Value("${wx_service_appid}")
	private String serviceAppId;
	
	/*服务号密钥*/
	@Value("${wx_service_key}")
	private String serviceKey;
	
	/*微信token url*/
	@Value("${wechat_token_url}")
	private String serviceTokenUrl;
	
	/*微信ticket url*/
	@Value("${wechat_ticket_url}")
	private String serviceTicketUrl;

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

	/**
	 * 获取微信支付统一下单url
	 * @return url
	 */
	public String getOrderUrl() {
		
		return orderUrl;
		
	}
	
	/**
	 * 获取签名密钥
	 * @return
	 */
	public String getSignKey() {
		return signKey;
	}

	/**
	 * 获取签名
	 * @param paramMap
	 * 		参数集合
	 * @return 签名
	 */
	public String getSign(MDataMap paramMap){
		
		if(paramMap.containsKey("sign")){
			
			paramMap.remove("sign");
			
		}
		
		String content = BeanComponent.getInstance().sortParam(Constants.SIGN_PARAM_SPLIT_AND, paramMap);
		
		content = content + Constants.SIGN_PARAM_SPLIT_AND + "key=" + getSignKey();
		
		return MD5.sign(content, Constants.CHARSET_UTF8).toUpperCase();
		
	}

	/**
	 * 获取服务号appid
	 * @return
	 */
	public String getServiceAppId() {
		return serviceAppId;
	}

	/**
	 * 服务密钥
	 * @return
	 */
	public String getServiceKey() {
		return serviceKey;
	}

	/**
	 * 公众号访问token路径
	 * @return
	 */
	public String getServiceTokenUrl() {
		return serviceTokenUrl;
	}

	/**
	 * jsapi ticket 请求路径
	 * @return
	 */
	public String getServiceTicketUrl() {
		return serviceTicketUrl;
	}
	
	/**
	 * 获取sha1加密后的签名
	 * @param mDataMap
	 * 		参数集合
	 * @return 签名字符串
	 */
	public String getShaSign(MDataMap mDataMap){
		
		String content = BeanComponent.getInstance().sortParam(Constants.SIGN_PARAM_SPLIT_AND, mDataMap);
		
		return SecrurityHelper.sha1(content);
		
	}
	
	

}
