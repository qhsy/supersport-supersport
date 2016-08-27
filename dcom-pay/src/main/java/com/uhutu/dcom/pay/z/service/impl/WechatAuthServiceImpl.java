package com.uhutu.dcom.pay.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.pay.z.common.Constants;
import com.uhutu.dcom.pay.z.config.PayConfigFactory;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.request.WechatAuthRequest;
import com.uhutu.dcom.pay.z.response.WechatAuthResponse;
import com.uhutu.dcom.pay.z.service.IWechatAuthService;
import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.dcom.pay.z.util.WechatUtil;
import com.uhutu.zoocom.helper.GsonHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.support.WebClientSupport;

/**
 * 微信授权业务实现
 * @author 逄小帅
 *
 */
@Service
public class WechatAuthServiceImpl implements IWechatAuthService {
	
	@Autowired
	private PayConfigFactory configFactory;

	@Override
	public IPayResponse doProcess(IPayRequest request, MDataMap paramMap) {
		
		WechatAuthRequest authRequest = (WechatAuthRequest) request;
		
		authRequest.setAppid(configFactory.getWechatConfig().getAppId(authRequest.getProcessType()));
		
		authRequest.setSecret(configFactory.getWechatConfig().getAppSecret(authRequest.getProcessType()));
		
		WechatAuthResponse authResponse = new WechatAuthResponse();
		
		try {
			
			MDataMap dataMap = BeanComponent.getInstance().objectToMap(authRequest, null, false);
			
			String paramStr = WechatUtil.conact(dataMap, Constants.SIGN_PARAM_SPLIT_QUEAL, Constants.SIGN_PARAM_SPLIT_AND);
			
			String url = configFactory.getWechatConfig().getServiceAuthUrl()+paramStr;
			
			String returnMsg = WebClientSupport.create().doGet(url);
			
			authResponse = GsonHelper.fromJson(returnMsg, authResponse);
			
		} catch (Exception e) {
			
			authResponse.setErrcode("fail");
			
			authResponse.setErrmsg(e.getMessage());
			
		}
		
		return authResponse;
	}

}
