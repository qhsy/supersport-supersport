package com.uhutu.dcom.pay.z.service.impl;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.pay.z.config.AlipayConfig;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.request.AlipayBizContentRequest;
import com.uhutu.dcom.pay.z.response.AlipayBizContentResponse;
import com.uhutu.dcom.pay.z.service.IAlipayService;
import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 支付宝业务实现
 * @author 逄小帅
 *
 */
@Service
public class AlipayServiceImpl implements IAlipayService {
	
	@Autowired
	private AlipayConfig alipayConfig;

	@Override
	public IPayResponse doProcess(IPayRequest request,MDataMap paramMap) {
		
		/*请求信息*/
		AlipayBizContentRequest bizContentRequest = null;
		
		/*响应信息*/
		AlipayBizContentResponse bizContentResponse = new AlipayBizContentResponse();
		
		if(request instanceof AlipayBizContentRequest){
			
			bizContentRequest = (AlipayBizContentRequest) request;
			
			bizContentResponse = initBizContetResponse(bizContentRequest);
			
		}else{
			
			bizContentResponse.inError(81110001);
			
		}
		
		return bizContentResponse;
		
	}
	
	
	/**
	 * 初始化支付响应信息
	 * @param bizConentRequest
	 * 		支付请求信息
	 * @return 支付响应信息
	 */
	public AlipayBizContentResponse initBizContetResponse(AlipayBizContentRequest bizConentRequest){
		
		AlipayBizContentResponse bizContentResponse = new AlipayBizContentResponse();
		
		try {
			
			MDataMap dataMap = BeanComponent.getInstance().objectToMap(bizContentResponse, null, false);
			
			bizContentResponse.set_input_charset(alipayConfig.getInputCharset());
			
			bizContentResponse.setBody(bizConentRequest.getBody());
			
			bizContentResponse.setIt_b_pay(DateFormatUtils.format(bizConentRequest.getExpire(), "yyyy-MM-dd HH:mm:ss"));
			
			String requestUrl = bizConentRequest.getRequestIP() + alipayConfig.getNotifyUrl();
			
			bizContentResponse.setNotify_url(requestUrl);
			
			bizContentResponse.setOut_trade_no(bizConentRequest.getOrderCode());
			
			bizContentResponse.setPartner(alipayConfig.getPartnerId());
			
			bizContentResponse.setPayment_type(alipayConfig.getPaymentType());
			
			bizContentResponse.setSeller_id(alipayConfig.getSellerId());
			
			bizContentResponse.setService(alipayConfig.getService());
			
			bizContentResponse.setSubject(bizConentRequest.getSubject());
			
			bizContentResponse.setTotal_fee(bizConentRequest.getTotal_fee().setScale(2));
			
			bizContentResponse.setSign_type(alipayConfig.getSignType());
			
			String sign = alipayConfig.getSign(dataMap);
			
			bizContentResponse.setSign(sign);
			
		} catch (Exception e) {
			
			bizContentResponse.setStatus(0);
			
			bizContentResponse.setError(e.getMessage());
			
		}
		
		return bizContentResponse;
		
	}

	
	
}
