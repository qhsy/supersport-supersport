package com.uhutu.sportcenter.z.api.pay;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.config.enums.SocialEnum;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.process.impl.PayGateProcess;
import com.uhutu.dcom.pay.z.request.WechatBizContentRequest;
import com.uhutu.dcom.pay.z.request.WechatH5PayRequest;
import com.uhutu.dcom.pay.z.request.WechatOrderRequest;
import com.uhutu.dcom.pay.z.response.WechatH5PayResponse;
import com.uhutu.dcom.pay.z.response.WechatOrderResponse;
import com.uhutu.dcom.pay.z.service.PayServiceFactory;
import com.uhutu.dcom.user.z.entity.UcSocialLogin;
import com.uhutu.dcom.user.z.entity.UcUserinfoSocial;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.input.ApiWechatH5PayInput;
import com.uhutu.sportcenter.z.result.ApiWechatH5PayResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

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
	private PayServiceFactory payServiceFactory;
	
	@Autowired
	private UserInfoSupport userInfoSupport;

	@Override
	protected ApiWechatH5PayResult process(ApiWechatH5PayInput input) {
		
		ApiWechatH5PayResult h5PayResult = new ApiWechatH5PayResult();
		
		UcUserinfoSocial ucUserinfoSocial = userInfoSupport.getUserInfoSocial(upUserCode());
		
		if(ucUserinfoSocial == null){
			
			h5PayResult.inError(81110004);
			
			return h5PayResult;
			
		}
		
		WechatBizContentRequest bizContentRequest = new WechatBizContentRequest();
		
		bizContentRequest.setOrderCode(input.getOrderCode());
		
		bizContentRequest.setRequestIP(input.getServeIP());

		bizContentRequest.setRomoteIp(input.getRomoteIP());
		
		bizContentRequest.setPayMoney(input.getPayMoney());
		
		UcSocialLogin socialLogin = JdbcHelper.queryOne(UcSocialLogin.class, "unionid",ucUserinfoSocial.getAccountId(),"type",SocialEnum.wechat_h5.name());
		
		bizContentRequest.setOpenid(socialLogin.getOpenid());
		
		WechatOrderRequest orderRequest = payServiceFactory.getWechatOrderService().initOrderRequest(bizContentRequest, PayProcessEnum.WECHAT_SERVICE_CONFIG);
		
		WechatOrderResponse orderResponse = (WechatOrderResponse) payGateProcess.process(PayProcessEnum.WECHAT_ORDER, orderRequest, new MDataMap());
		
		if(orderResponse.upResultFlag()){
			
			WechatH5PayRequest h5PayRequest = new WechatH5PayRequest();
			
			h5PayRequest.setPrePayId(orderResponse.getPrepay_id());
			
			WechatH5PayResponse h5PayResponse = (WechatH5PayResponse) payGateProcess.process(PayProcessEnum.WECHAT_H5, h5PayRequest, new MDataMap());
			
			h5PayResult.setWechatH5PayInfo(h5PayResponse);
			
		}else{
			
			h5PayResult.setStatus(0);
			
			String returnMsg = "";
			
			if(StringUtils.isNotBlank(orderResponse.getErr_code_des())){
				
				returnMsg = returnMsg + orderResponse.getErr_code_des(); 
				
			}
			
			if(StringUtils.isNotBlank(orderResponse.getReturn_msg())){
				
				returnMsg = returnMsg + orderResponse.getReturn_msg();
				
			}
			
			h5PayResult.setError(returnMsg);
			
		}
		
		return h5PayResult;
		
	}
	
	

}
