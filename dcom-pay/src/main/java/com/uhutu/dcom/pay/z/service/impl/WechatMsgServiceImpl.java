package com.uhutu.dcom.pay.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.pay.z.common.Constants;
import com.uhutu.dcom.pay.z.common.WechatMsgEnum;
import com.uhutu.dcom.pay.z.config.PayConfigFactory;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.request.WechatMsgRequest;
import com.uhutu.dcom.pay.z.response.WechatAccessTokenResponse;
import com.uhutu.dcom.pay.z.response.WechatMsgResponse;
import com.uhutu.dcom.pay.z.service.IWechatAccessTokenService;
import com.uhutu.dcom.pay.z.service.IWechatMsgService;
import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.zoocom.helper.GsonHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.support.WebClientSupport;

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
		
		String data = GsonHelper.toJson(request);
		
		WechatMsgRequest msgRequest = new WechatMsgRequest();
		
		msgRequest.setTouser(paramMap.get(Constants.KEY_OPENID));
		
		String name = paramMap.get(Constants.KEY_TEMPLETID);
		
		msgRequest.setTemplate_id(templetId(name));
		
		msgRequest.setData(data);
		
		WechatAccessTokenResponse tokenResponse = (WechatAccessTokenResponse) wechatAccessTokenService.doProcess(null, new MDataMap());
		
		String sUrl = configFactory.getWechatMsgConfig().getSendUrl() + tokenResponse.getAccess_token();
		
		try {
			
			MDataMap mDataMap = BeanComponent.getInstance().objectToMap(msgRequest, null, false);
			
			String returnMsg = WebClientSupport.create().upPost(sUrl, mDataMap);
			
			msgResponse = GsonHelper.fromJson(returnMsg, msgResponse);
			
		} catch (Exception e) {
			
			msgResponse.setErrcode("local");
			
			msgResponse.setErrmsg(e.getMessage());
			
		}
		
		return msgResponse;
	}
	
	/**
	 * 模板标识
	 * @param name
	 * 		枚举名称
	 * @return 模版标识
	 */
	public String templetId(String name){
		
		String templetId = "";
		
		switch (WechatMsgEnum.valueOf(name)) {
		case ASK:
			templetId = configFactory.getWechatMsgConfig().getAskId();
			break;
		case REFUND:
			templetId = configFactory.getWechatMsgConfig().getRefundId();
			break;
		case REMARK:
			templetId = configFactory.getWechatMsgConfig().getRemarkId();
			break;
		default:
			break;
		}
		
		return templetId;
		
	}

}
