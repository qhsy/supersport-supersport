package com.uhutu.dcom.pay.z.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.pay.z.common.Constants;
import com.uhutu.dcom.pay.z.config.PayConfigFactory;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.request.WechatAccessTokenRequest;
import com.uhutu.dcom.pay.z.response.WechatAccessTokenResponse;
import com.uhutu.dcom.pay.z.service.IWechatAccessTokenService;
import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.dcom.pay.z.util.WechatUtil;
import com.uhutu.zoocom.face.IKvCall;
import com.uhutu.zoocom.helper.GsonHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.support.WebClientSupport;
import com.uhutu.zoocom.z.helper.KvHelper;

/**
 * 
 * @author 逄小帅
 *
 */
@Service
public class WechatAccessTokenServiceImpl implements IWechatAccessTokenService {

	@Autowired
	private PayConfigFactory payConfigFactory;

	@Override
	public IPayResponse doProcess(IPayRequest request, MDataMap paramMap) {
		
		WechatAccessTokenRequest accessTokenRequest = null;
		
		if(request == null){
			
			accessTokenRequest = new WechatAccessTokenRequest();
			
			accessTokenRequest.setAppid(payConfigFactory.getWechatConfig().getServiceAppId());
			
			accessTokenRequest.setSecret(payConfigFactory.getWechatConfig().getServiceKey());
			
		}
		
		WechatAccessTokenResponse accessTokenResponse = new WechatAccessTokenResponse();
		
		try {
			
			String key ="access_token";
			
			IKvCall accessToken = KvHelper.upFactory(Constants.PROJECT_BASE+"-"+Constants.PROJECT_PAY);
			
			String accessTokenStr = "";
			
			if(accessToken.exists(key) && accessToken.ttl(key) > 0){
				
				accessTokenStr = accessToken.get(key);
				
			}else{
				
				accessTokenStr = "";
				
			}
			
			if(StringUtils.isEmpty(accessTokenStr)){
				
				MDataMap mdataMap = BeanComponent.getInstance().objectToMap(accessTokenRequest, null, false);
				
				String paramStr = WechatUtil.conact(mdataMap, Constants.SIGN_PARAM_SPLIT_QUEAL, Constants.SIGN_PARAM_SPLIT_AND);
				
				String sUrl = payConfigFactory.getWechatConfig().getServiceTokenUrl()+paramStr;
				
				String returnMsg = WebClientSupport.create().doGet(sUrl);
				
				accessTokenResponse = GsonHelper.fromJson(returnMsg, accessTokenResponse);
				
				accessToken.set(key, accessTokenResponse.getAccess_token());
				
				accessToken.expire(key, accessTokenResponse.getExpires_in().intValue());
				
			}else{
				
				accessTokenResponse.setAccess_token(accessTokenStr);
				
				accessTokenResponse.setExpires_in(accessToken.ttl(key));
				
			}
			
		} catch (Exception e) {
			
			accessTokenResponse.setErrcode(0);;
			
			accessTokenResponse.setErrmsg(e.getMessage());;
			
		}
		
		return accessTokenResponse;
		
	}

}
