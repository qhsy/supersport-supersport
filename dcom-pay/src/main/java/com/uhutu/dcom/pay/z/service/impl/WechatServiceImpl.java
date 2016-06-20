package com.uhutu.dcom.pay.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.uhutu.dcom.component.z.util.WebClientComponent;
import com.uhutu.dcom.pay.z.config.WechatConfig;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.request.WechatBizContentRequest;
import com.uhutu.dcom.pay.z.response.WechatOrderResponse;
import com.uhutu.dcom.pay.z.response.WechatPayResponse;
import com.uhutu.dcom.pay.z.service.IWechatService;
import com.uhutu.zoocom.helper.GsonHelper;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 微信支付业务实现
 * @author 逄小帅
 *
 */
public class WechatServiceImpl implements IWechatService {
	
	@Autowired
	private WechatConfig wechatConfig;

	@Override
	public IPayResponse doProcess(IPayRequest request) {
		
		WechatBizContentRequest bizContentRequest = (WechatBizContentRequest) request;
		
		WechatPayResponse payResponse = new WechatPayResponse();
		
		try {
			
			WechatOrderResponse orderResponse = new WechatOrderResponse();
			
			String responseMsg = WebClientComponent.doXmpRequest(wechatConfig.getOrderUrl(), "");
			
			orderResponse = GsonHelper.fromJson(responseMsg, orderResponse);
			
			
		} catch (Exception e) {
			
			payResponse.setStatus(0);
			
			payResponse.setError(e.getMessage());
			
		}
		
		return payResponse;
	}

}
