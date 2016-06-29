package com.uhutu.dcom.pay.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.config.WechatConfig;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.request.WechatBizContentRequest;
import com.uhutu.dcom.pay.z.request.WechatOrderRequest;
import com.uhutu.dcom.pay.z.response.WechatOrderResponse;
import com.uhutu.dcom.pay.z.response.WechatPayResponse;
import com.uhutu.dcom.pay.z.service.IWechatOrderService;
import com.uhutu.dcom.pay.z.service.IWechatService;
import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.dcom.pay.z.util.WechatUtil;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 微信支付业务实现
 * @author 逄小帅
 *
 */
@Service
public class WechatServiceImpl implements IWechatService {
	
	@Autowired
	private IWechatOrderService wechatOrderService;
	
	@Autowired
	private WechatConfig wechatConfig;

	@Override
	public IPayResponse doProcess(IPayRequest request,MDataMap paramMap) {
		
		WechatBizContentRequest bizContentRequest = (WechatBizContentRequest) request;
		
		WechatPayResponse payResponse = new WechatPayResponse();
		
		if(request instanceof WechatBizContentRequest){
			
			try {
				
				WechatOrderRequest orderRequest = wechatOrderService.initOrderRequest(bizContentRequest,PayProcessEnum.WECHAT);
				
				WechatOrderResponse orderResponse = (WechatOrderResponse) wechatOrderService.doProcess(orderRequest, new MDataMap());
				
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
		
		payResponse.setNoncestr(WechatUtil.getNonceStr());
		
		payResponse.setTimestamp(WechatUtil.getTimeStamp());
		
		try {
			
			MDataMap dataMap = BeanComponent.getInstance().objectToMap(payResponse, null, false);
			
			String sign = wechatConfig.getSign(dataMap,PayProcessEnum.WECHAT);
			
			payResponse.setSign(sign);
			
		} catch (Exception e) {
			
			payResponse.setStatus(0);
			
			payResponse.setError(e.getMessage());
			
		}
		
		return payResponse;
		
		
	}

}
