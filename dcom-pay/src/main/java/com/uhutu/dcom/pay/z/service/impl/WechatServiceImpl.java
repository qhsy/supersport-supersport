package com.uhutu.dcom.pay.z.service.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import com.uhutu.dcom.component.z.util.WebClientComponent;
import com.uhutu.dcom.pay.z.config.WechatConfig;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.request.WechatBizContentRequest;
import com.uhutu.dcom.pay.z.request.WechatOrderRequest;
import com.uhutu.dcom.pay.z.response.WechatOrderResponse;
import com.uhutu.dcom.pay.z.response.WechatPayResponse;
import com.uhutu.dcom.pay.z.service.IWechatService;
import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.dcom.pay.z.util.XmlUtil;
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
		
		if(request instanceof WechatBizContentRequest){
			
			try {
				
				WechatOrderResponse orderResponse = new WechatOrderResponse();
				
				WechatOrderRequest orderRequest = initOrderRequest(bizContentRequest);
				
				MDataMap requestContentMap = BeanComponent.getInstance().objectToMap(orderRequest, null, false);
				
				String xmlStr = XmlUtil.getInstance().mDataMapToXml(requestContentMap);
				
				String responseMsg = WebClientComponent.doXmpRequest(wechatConfig.getOrderUrl(), xmlStr);
				
				orderResponse = GsonHelper.fromJson(responseMsg, orderResponse);
				
				if(orderResponse.upReturnFalg()){
					
					if(orderResponse.upResultFlag()){
						
						payResponse = initPayResponse(orderResponse);
						
					}else{
						
						payResponse.setStatus(0);
						
						payResponse.setError(orderResponse.getErr_code()+":"+orderResponse.getErr_code_des());
						
					}
					
				}else{
					
					
					payResponse.setStatus(0);
					
					payResponse.setError(orderResponse.getReturn_msg());
					
				}
				
			} catch (Exception e) {
				
				payResponse.setStatus(0);
				
				payResponse.setError(e.getMessage());
				
			}
			
		}else{
			
			payResponse.inError(81110002);
			
		}
		
		return payResponse;
	}
	
	/**
	 * 初始化支付响应信息
	 * @param orderResponse
	 * 		订单响应信息
	 * @return 微信支付响应信息
	 */
	public WechatPayResponse initPayResponse(WechatOrderResponse orderResponse){
		
		WechatPayResponse payResponse = new WechatPayResponse();
		
		payResponse.setAppid(orderResponse.getAppid());
		
		payResponse.setPartnerid(orderResponse.getMch_id());
		
		payResponse.setPrepayid(orderResponse.getPrepay_id());
		
		Date sendTime = new Date();
		
		payResponse.setTimestamp(Long.toString(sendTime.getTime()));
		
		try {
			
			MDataMap dataMap = BeanComponent.getInstance().objectToMap(payResponse, null, false);
			
			String sign = wechatConfig.getSign(dataMap);
			
			payResponse.setSign(sign);
			
		} catch (Exception e) {
			
			payResponse.setStatus(0);
			
			payResponse.setError(e.getMessage());
			
		}
		
		return payResponse;
		
		
	}
	
	/**
	 * 初始化统一下单请求信息
	 * @param bizContentRequest
	 * 		业务内容请求信息
	 * @return 微信订单请求对象
	 */
	public WechatOrderRequest initOrderRequest(WechatBizContentRequest bizContentRequest){
		
		WechatOrderRequest orderRequest = new WechatOrderRequest();
		
		orderRequest.setAppid(wechatConfig.getAppId());
		
		orderRequest.setBody("");
		
		orderRequest.setMch_id(wechatConfig.getMchId());
		
		orderRequest.setNoncestr("");
		
		orderRequest.setNotify_url(wechatConfig.getNotifyUrl());
		
		orderRequest.setOut_trade_no("");
		
		orderRequest.setTime_expire("");
		
		orderRequest.setTime_start("");
		
		orderRequest.setTrade_type(wechatConfig.getTradeType());
		
		try {
			
			MDataMap mDataMap = BeanComponent.getInstance().objectToMap(orderRequest, null, false);
			
			String sign = wechatConfig.getSign(mDataMap);
			
			orderRequest.setSign(sign);
			
		} catch (Exception e) {
			
			orderRequest = null;
			
		}
		
		return orderRequest;
		
	}

}
