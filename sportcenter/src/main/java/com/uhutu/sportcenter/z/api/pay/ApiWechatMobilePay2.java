package com.uhutu.sportcenter.z.api.pay;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.entity.PaPayInfo;
import com.uhutu.dcom.pay.z.process.impl.PayGateProcess;
import com.uhutu.dcom.pay.z.request.WechatBizContentRequest;
import com.uhutu.dcom.pay.z.request.WechatOrderRequest;
import com.uhutu.dcom.pay.z.request.WechatPayRequest;
import com.uhutu.dcom.pay.z.response.WechatOrderResponse;
import com.uhutu.dcom.pay.z.response.WechatPayResponse;
import com.uhutu.dcom.pay.z.service.PayServiceFactory;
import com.uhutu.sportcenter.z.input.ApiWechatMobilePayInput;
import com.uhutu.sportcenter.z.result.ApiWechatMobilePayResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 微信移动支付
 * @author 逄小帅
 *
 */
@Component
public class ApiWechatMobilePay2 extends RootApiToken<ApiWechatMobilePayInput, ApiWechatMobilePayResult> {
	
	@Autowired
	private PayGateProcess payGateProcess;
	
	@Autowired
	private PayServiceFactory payServiceFactory;

	@Override
	protected ApiWechatMobilePayResult process(ApiWechatMobilePayInput input) {
		
		ApiWechatMobilePayResult mobilePayResult = new ApiWechatMobilePayResult();
		
		WechatBizContentRequest bizContentRequest = new WechatBizContentRequest();
		
		bizContentRequest.setOrderCode(input.getOrderCode());
		
		bizContentRequest.setRequestIP(input.getServeIP());

		bizContentRequest.setRomoteIp(input.getRomoteIP());
		
		BigDecimal payMoney = BigDecimal.ZERO;
		
		PaPayInfo paPayInfo = JdbcHelper.queryOne(PaPayInfo.class, "busiCode",input.getOrderCode());
		
		if(paPayInfo == null){
			
			payMoney = input.getPayMoney();
			
		}else{
			
			payMoney = paPayInfo.getMoney();
			
			bizContentRequest.setOrderSource(paPayInfo.getPaySource());
			
			bizContentRequest.setOrderType(paPayInfo.getBusiType());
			
			
		}
		
		bizContentRequest.setPayMoney(payMoney);
		
		WechatOrderRequest orderRequest = payServiceFactory.getWechatOrderService().initOrderRequest(bizContentRequest, PayProcessEnum.WECHAT);
		
		WechatOrderResponse orderResponse = (WechatOrderResponse) payGateProcess.process(PayProcessEnum.WECHAT_ORDER, orderRequest, new MDataMap());
		
		if(orderResponse.upResultFlag()){
			
			WechatPayRequest payRequest = new WechatPayRequest();
			
			payRequest.setPrePayId(orderResponse.getPrepay_id());
			
			WechatPayResponse mobilePayResponse = (WechatPayResponse) payGateProcess.process(PayProcessEnum.WECHAT, payRequest, new MDataMap());
			
			mobilePayResult.setMobilePayInfo(mobilePayResponse);
			
		}else{
			
			mobilePayResult.setStatus(0);
			
			String returnMsg = "";
			
			if(StringUtils.isNotBlank(orderResponse.getErr_code_des())){
				
				returnMsg = returnMsg + orderResponse.getErr_code_des(); 
				
			}
			
			if(StringUtils.isNotBlank(orderResponse.getReturn_msg())){
				
				returnMsg = returnMsg + orderResponse.getReturn_msg();
				
			}
			
			mobilePayResult.setError(returnMsg);
			
		}
		
		return mobilePayResult;
		
	}
	
	

}
