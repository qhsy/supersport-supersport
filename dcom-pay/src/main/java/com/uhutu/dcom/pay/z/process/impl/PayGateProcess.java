package com.uhutu.dcom.pay.z.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.face.IPayService;
import com.uhutu.dcom.pay.z.process.IPayGateProcess;
import com.uhutu.dcom.pay.z.service.PayServiceFactory;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 支付宝业务解析
 * @author 逄小帅
 *
 */
@Service
public class PayGateProcess implements IPayGateProcess {
	
	@Autowired
	private PayServiceFactory payServiceFactory;

	@Override
	public IPayResponse process(PayProcessEnum processEnum,IPayRequest request,MDataMap paramMap) {
		
		return upPayService(processEnum).doProcess(request,paramMap);
	}
	
	@Override
	public IPayService upPayService(PayProcessEnum processEnum) {

		IPayService payService = null;

		switch (processEnum) {
		case ALIPAY:
			payService = payServiceFactory.getAlipayService();
			break;
		case WECHAT:
			payService = payServiceFactory.getWechatService();
			break;		
		case WECHAT_NOTIFY:
			payService = payServiceFactory.getWechatNotifyService();
			break;
		case ALIPAY_NOTIFY:
			payService = payServiceFactory.getAlipayNotifyService();
		case WECHATH5_NOTIFY:
			payService = payServiceFactory.getWechatNotifyService();
			break;
		case WECHAT_SERVICE_CONFIG:
			payService = payServiceFactory.getWechatConfigService();
			break;
		case WECHAT_H5:
			payService = payServiceFactory.getWechatH5PayService();
			break;
		case WECHAT_AUTH:
			payService = payServiceFactory.getWechatAuthService();
			break;
		case WECHAT_TOKEN:
			payService = payServiceFactory.getWechatAccessTokenService();
			break;
		case WECHAT_USER:
			payService = payServiceFactory.getWechatUserInfoService();
			break;
		case WECHAT_MSG:
			payService = payServiceFactory.getWechatMsgService();
			break;
		case WECHAT_ORDER:
			payService = payServiceFactory.getWechatOrderService();
			break;
		case WECHAT_COM:
			payService = payServiceFactory.getWechatComPayService();
			break;
		case GOLD_COIN:
			payService = payServiceFactory.getGoldCoinPayService();
			break;
		case WECHAT_CF:
			payService = payServiceFactory.getWechatService();
			break;
		case WECHAT_H5_CF:
			payService = payServiceFactory.getWechatH5PayService();
			break;
		case WECHAT_CF_NOTIFY:
			payService = payServiceFactory.getWechatNotifyService();
			break;
		case WECHAT_CFH5_NOTIFY:
			payService = payServiceFactory.getWechatNotifyService();
			break;
		default:
			break;
		}

		return payService;

	}
	
}
