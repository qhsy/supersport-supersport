package com.uhutu.dcom.pay.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.util.WebClientComponent;
import com.uhutu.dcom.pay.z.common.Constants;
import com.uhutu.dcom.pay.z.common.WechatUnifyResultCodeEnum;
import com.uhutu.dcom.pay.z.config.PayConfigFactory;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.request.WechatMsgRequest;
import com.uhutu.dcom.pay.z.response.WechatAccessTokenResponse;
import com.uhutu.dcom.pay.z.response.WechatMsgResponse;
import com.uhutu.dcom.pay.z.service.IWechatAccessTokenService;
import com.uhutu.dcom.pay.z.service.IWechatMsgService;
import com.uhutu.zoocom.helper.GsonHelper;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 微信消息通知业务实现(map里需传openid,templetid字段)
 * @author 逄小帅
 *
 */
@Service
public class WechatMsgServiceImpl implements IWechatMsgService {
	
	@Autowired
	private PayConfigFactory configFactory;
	
	@Autowired
	private IWechatAccessTokenService wechatAccessTokenService;

	@Override
	public IPayResponse doProcess(IPayRequest request, MDataMap paramMap) {
		
		WechatMsgResponse msgResponse = new WechatMsgResponse();
		
		WechatMsgRequest msgRequest = new WechatMsgRequest();
		
		msgRequest.setTouser(paramMap.get(Constants.KEY_OPENID));
		
		msgRequest.setTemplate_id(paramMap.get(Constants.KEY_TEMPLETID));
		
		msgRequest.setUrl(paramMap.get(Constants.KEY_REDIRECTURL));
		
		msgRequest.setData(request);
		
		WechatAccessTokenResponse tokenResponse = (WechatAccessTokenResponse) wechatAccessTokenService.doProcess(null, new MDataMap());
		
		String sUrl = configFactory.getWechatMsgConfig().getSendUrl() + tokenResponse.getAccess_token();
		
		try {
			
			String requestJson = GsonHelper.toJson(msgRequest);
			
			String returnMsg = WebClientComponent.upRequest(sUrl, requestJson);
			
			msgResponse = GsonHelper.fromJson(returnMsg, msgResponse);
			
		} catch (Exception e) {
			
			msgResponse.setErrcode(WechatUnifyResultCodeEnum.FAIL.name());
			
			msgResponse.setErrmsg(e.getMessage());
			
		}
		
		return msgResponse;
	}
}
