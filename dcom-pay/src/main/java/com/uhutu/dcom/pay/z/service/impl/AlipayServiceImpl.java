package com.uhutu.dcom.pay.z.service.impl;

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
	public IPayResponse doProcess(IPayRequest request) {
		
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
			
			String sign = alipayConfig.getSign(dataMap);
			
			bizContentResponse.setSign(sign);
			
		} catch (Exception e) {
			
			bizContentResponse.setStatus(0);
			
			bizContentResponse.setError(e.getMessage());
			
		}
		
		return bizContentResponse;
		
	}

	
	
}
