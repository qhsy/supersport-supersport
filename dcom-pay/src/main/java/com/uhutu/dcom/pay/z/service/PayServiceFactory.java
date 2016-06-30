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

}
