package com.uhutu.dcom.pay.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.pay.z.common.Constants;
import com.uhutu.dcom.pay.z.config.PayConfigFactory;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.request.WechatUserInfoRequest;
import com.uhutu.dcom.pay.z.response.WechatUserInfoResponse;
import com.uhutu.dcom.pay.z.service.IWechatUserInfoService;
import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.dcom.pay.z.util.WechatUtil;
import com.uhutu.zoocom.helper.GsonHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.support.WebClientSupport;

/**
 * 拉取用户信息业务实现
 * @author 逄小帅
 *
 */
@Service
public class WechatUserInfoServiceImpl implements IWechatUserInfoService {
	
	@Autowired
	private PayConfigFactory configFactory;

	@Override
	public IPayResponse doProcess(IPayRequest request, MDataMap paramMap) {
		
		WechatUserInfoRequest userInfoRequest = (WechatUserInfoRequest) request;
		
		WechatUserInfoResponse userInfoResponse = new WechatUserInfoResponse();
		
		try {
			
			MDataMap dataMap = BeanComponent.getInstance().objectToMap(userInfoRequest, null, false);
			
			String paramStr = WechatUtil.conact(dataMap, Constants.SIGN_PARAM_SPLIT_QUEAL, Constants.SIGN_PARAM_SPLIT_AND);
			
			String sUrl = configFactory.getWechatConfig().getServiceUserInfoUrl()+paramStr;
			
			String returnMsg = WebClientSupport.create().doGet(sUrl);
			
			returnMsg = new String(returnMsg.getBytes("ISO-8859-1"),"UTF-8");
			
			userInfoResponse = GsonHelper.fromJson(returnMsg, userInfoResponse);
			
		} catch (Exception e) {
			
			userInfoResponse.setStatus(0);
			
			userInfoResponse.setError(e.getMessage());
			
		}
		
		return userInfoResponse;
	}

}
