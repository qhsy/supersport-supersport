package com.uhutu.dcom.pay.z.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 支付业务factory
 * @author 逄小帅
 *
 */
@Component
public class PayServiceFactory {
	
	@Autowired
	private IAlipayService alipayService;
	
	@Autowired
	private IWechatService wechatService;
	
	@Autowired 
	private IAlipayNotifyService alipayNotifyService;
	
	@Autowired
	private IWechatNotifyService wechatNotifyService;
	
	@Autowired
	private IWechatConfigService wechatConfigService;
	
	@Autowired
	private IWechatH5PayService wechatH5PayService;
	
	@Autowired
	private IWechatAuthService wechatAuthService;
	
	@Autowired 
	private IWechatUserInfoService wechatUserInfoService;
	
	@Autowired
	private IWechatAccessTokenService wechatAccessTokenService;
	
	@Autowired
	private IWechatMsgService wechatMsgService;
	
	@Autowired
	private IWechatOrderService wechatOrderService;
	
	@Autowired
	private IWechatComPayService wechatComPayService;
	
	@Autowired
	private IPaInclogInfoService paInclogInfoService;
	
	@Autowired
	private IGoldCoinPayService goldCoinPayService;
	
	@Autowired
	private IPaCoinInfoService paCoinInfoService;

	public IAlipayService getAlipayService() {
		return alipayService;
	}

	public IWechatService getWechatService() {
		return wechatService;
	}

	public IAlipayNotifyService getAlipayNotifyService() {
		return alipayNotifyService;
	}

	public IWechatNotifyService getWechatNotifyService() {
		return wechatNotifyService;
	}

	public IWechatConfigService getWechatConfigService() {
		return wechatConfigService;
	}

	public IWechatH5PayService getWechatH5PayService() {
		return wechatH5PayService;
	}

	public IWechatAuthService getWechatAuthService() {
		return wechatAuthService;
	}

	public IWechatUserInfoService getWechatUserInfoService() {
		return wechatUserInfoService;
	}

	public IWechatAccessTokenService getWechatAccessTokenService() {
		return wechatAccessTokenService;
	}

	public IWechatMsgService getWechatMsgService() {
		return wechatMsgService;
	}

	public IWechatOrderService getWechatOrderService() {
		return wechatOrderService;
	}

	public IWechatComPayService getWechatComPayService() {
		return wechatComPayService;
	}

	public IPaInclogInfoService getPaInclogInfoService() {
		return paInclogInfoService;
	}

	public IGoldCoinPayService getGoldCoinPayService() {
		return goldCoinPayService;
	}

	public IPaCoinInfoService getPaCoinInfoService() {
		return paCoinInfoService;
	}

}
