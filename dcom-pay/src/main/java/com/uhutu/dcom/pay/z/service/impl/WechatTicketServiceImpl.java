package com.uhutu.dcom.pay.z.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.pay.z.common.Constants;
import com.uhutu.dcom.pay.z.config.PayConfigFactory;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.request.WechatTicketRequest;
import com.uhutu.dcom.pay.z.response.WechatTicketResponse;
import com.uhutu.dcom.pay.z.service.IWechatTicketService;
import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.dcom.pay.z.util.WechatUtil;
import com.uhutu.zoocom.face.IKvCall;
import com.uhutu.zoocom.helper.GsonHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.support.WebClientSupport;
import com.uhutu.zoocom.z.helper.KvHelper;

/**
 * 微信jsapi ticket业务实现
 * @author 逄小帅
 *
 */
@Service
public class WechatTicketServiceImpl implements IWechatTicketService {
	
	@Autowired
	private PayConfigFactory payConfigFactory;

	@Override
	public IPayResponse doProcess(IPayRequest request, MDataMap paramMap) {
		
		WechatTicketRequest ticketRequest = (WechatTicketRequest) request;
		
		WechatTicketResponse ticketResponse = new WechatTicketResponse();
		
		try {
			
			String key ="jsapi_ticket";
			
			IKvCall apiTicket = KvHelper.upFactory(Constants.PROJECT_BASE+"-"+Constants.PROJECT_PAY);
			
			String jsapiTicketStr = "";
			
			if(apiTicket.exists(key) && apiTicket.ttl(key) > 0){
				
				jsapiTicketStr = apiTicket.get(key);
				
			}else{
				
				jsapiTicketStr = "";
				
			}
			
			if(StringUtils.isEmpty(jsapiTicketStr)){
				
				MDataMap mdataMap = BeanComponent.getInstance().objectToMap(ticketRequest, null, false);
				
				String paramStr = WechatUtil.conact(mdataMap, Constants.SIGN_PARAM_SPLIT_QUEAL, Constants.SIGN_PARAM_SPLIT_AND);
				
				String sUrl = payConfigFactory.getWechatConfig().getServiceTicketUrl()+paramStr;
				
				String returnMsg = WebClientSupport.create().doGet(sUrl);
				
				ticketResponse = GsonHelper.fromJson(returnMsg, ticketResponse);
				
				apiTicket.expire(key, ticketResponse.getExpires_in().intValue());
				
				apiTicket.set(key, ticketResponse.getTicket());
				
				
			}else{
				
				ticketResponse.setTicket(jsapiTicketStr);
				
				ticketResponse.setExpires_in(apiTicket.ttl(key));
				
			}
			
		} catch (Exception e) {
			
			ticketResponse.setErrcode(0);;
			
			ticketResponse.setErrmsg(e.getMessage());;
			
		}
		
		return ticketResponse;
		
	
	}

}
