package com.uhutu.sportcenter.z.api.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.process.impl.PayGateProcess;
import com.uhutu.dcom.pay.z.request.WechatBizContentRequest;
import com.uhutu.dcom.pay.z.request.WechatH5PayRequest;
import com.uhutu.dcom.pay.z.request.WechatOrderRequest;
import com.uhutu.dcom.pay.z.response.WechatH5PayResponse;
import com.uhutu.dcom.pay.z.response.WechatOrderResponse;
import com.uhutu.dcom.pay.z.service.PayServiceFactory;
import com.uhutu.sportcenter.z.input.ApiWechatH5PayInput;
import com.uhutu.sportcenter.z.result.ApiWechatH5PayResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 微信h5支付
 * @author 逄小帅
 *
 */
@Component
public class ApiWechatH5Pay extends RootApiToken<ApiWechatH5PayInput, ApiWechatH5PayResult> {
	
	@Autowired
	private PayGateProcess payGateProcess;
	
	@Autowired
	private AnswerServiceFactory answerServiceFactory;
	
	@Autowired
	private PayServiceFactory payServiceFactory;

	@Override
	protected ApiWechatH5PayResult process(ApiWechatH5PayInput input) {
		
		ApiWechatH5PayResult h5PayResult = new ApiWechatH5PayResult();
		
		AwQuestionInfo awQuestionInfo = answerServiceFactory.getQuestionInfoService().queryByCode(input.getQuestionCode());
		
		WechatBizContentRequest bizContentRequest = new WechatBizContentRequest();
		
		bizContentRequest.setBody(awQuestionInfo.getContent());
		
		bizContentRequest.setOrderCode(input.getQuestionCode());
		
		bizContentRequest.setRequestIP(input.getServeIP());

		bizContentRequest.setRomoteIp(input.getRomoteIP());
		
		WechatOrderRequest orderRequest = payServiceFactory.getWechatOrderService().initOrderRequest(bizContentRequest, PayProcessEnum.WECHAT_SERVICE_CONFIG);
		
		WechatOrderResponse orderResponse = (WechatOrderResponse) payGateProcess.process(PayProcessEnum.WECHAT_ORDER, orderRequest, new MDataMap());
		
		if(orderResponse.upResultFlag()){
			
			WechatH5PayRequest h5PayRequest = new WechatH5PayRequest();
			
			h5PayRequest.setPrePayId(orderResponse.getPrepay_id());
			
			WechatH5PayResponse h5PayResponse = (WechatH5PayResponse) payGateProcess.process(PayProcessEnum.WECHAT_H5, h5PayRequest, new MDataMap());
			
			h5PayResult.setWechatH5PayInfo(h5PayResponse);
			
		}else{
			
			h5PayResult.setStatus(0);
			
			h5PayResult.setError(orderResponse.getErr_code_des());
			
		}
		
		return h5PayResult;
		
	}
	
	

}
