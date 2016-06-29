package com.uhutu.dcom.pay.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.pay.z.config.PayConfigFactory;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.request.WechatConfigRequest;
import com.uhutu.dcom.pay.z.request.WechatTicketRequest;
import com.uhutu.dcom.pay.z.response.WechatAccessTokenResponse;
import com.uhutu.dcom.pay.z.response.WechatConfigResponse;
import com.uhutu.dcom.pay.z.response.WechatTicketResponse;
import com.uhutu.dcom.pay.z.service.IWechatAccessTokenService;
import com.uhutu.dcom.pay.z.service.IWechatConfigService;
import com.uhutu.dcom.pay.z.service.IWechatTicketService;
import com.uhutu.dcom.pay.z.util.WechatUtil;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 微信配置信息业务实现
 * @author 逄小帅
 *
 */
@Service
public class WechatConfigServiceImpl implements IWechatConfigService {
	
	@Autowired
	private IWechatAccessTokenService accessTokenService;
	
	@Autowired
	private IWechatTicketService ticketService;
	
	@Autowired
	private PayConfigFactory configFactory;

	@Override
	public IPayResponse doProcess(IPayRequest request, MDataMap paramMap) {
		
		WechatConfigRequest configRequest = (WechatConfigRequest) request;
		
		WechatConfigResponse configResponse = new WechatConfigResponse();
		
		configResponse.setAppId(configFactory.getWechatConfig().getServiceAppId());
		
		configResponse.setNonceStr(WechatUtil.getNonceStr());
		
		configResponse.setTimestamp(WechatUtil.getTimeStamp());
		
		WechatAccessTokenResponse tokenResponse = doTokenResponse();
		
		WechatTicketResponse ticketResponse = doTicketResponse(tokenResponse.getAccess_token());
		
		MDataMap mDataMap = new MDataMap();
		
		mDataMap.put("jsapi_ticket", ticketResponse.getTicket());
		
		mDataMap.put("noncestr", configResponse.getNonceStr());
		
		mDataMap.put("timestamp", configResponse.getTimestamp());
		
		mDataMap.put("url", configRequest.getUrl());
		
		String sign = configFactory.getWechatConfig().getShaSign(mDataMap);
		
		configResponse.setSignature(sign);
		
		return configResponse;
	}
	
	/**
	 * 获取接口全局统一接口token
	 * @return
	 */
	public WechatAccessTokenResponse doTokenResponse(){
		
		return (WechatAccessTokenResponse) accessTokenService.doProcess(null, new MDataMap());
		
	}
	
	/**
	 * 获取jsapi ticket信息
	 * @param token
	 * 		全局token
	 * @return 票据响应信息
	 */
	public WechatTicketResponse doTicketResponse(String token){
		
		WechatTicketRequest ticketRequest = new WechatTicketRequest();
		
		ticketRequest.setAccess_token(token);
		
		ticketRequest.setType("jsapi");
		
		return (WechatTicketResponse) ticketService.doProcess(ticketRequest, new MDataMap());
		
	}

}
