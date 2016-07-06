package com.uhutu.dcom.pay.z.service.impl;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.util.WebClientComponent;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.common.WechatUnifyResultCodeEnum;
import com.uhutu.dcom.pay.z.config.PayConfigFactory;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.request.WechatBizContentRequest;
import com.uhutu.dcom.pay.z.request.WechatOrderRequest;
import com.uhutu.dcom.pay.z.response.WechatOrderResponse;
import com.uhutu.dcom.pay.z.service.IWechatOrderService;
import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.dcom.pay.z.util.WechatUtil;
import com.uhutu.dcom.pay.z.util.XmlUtil;
import com.uhutu.zoocom.helper.GsonHelper;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 微信订单业务实现
 * @author 逄小帅
 *
 */
@Service
public class WechatOrderServiceImpl implements IWechatOrderService {
	
	@Autowired
	private PayConfigFactory configFactory;

	@Override
	public IPayResponse doProcess(IPayRequest request, MDataMap paramMap) {
		
		WechatOrderResponse orderResponse = new WechatOrderResponse();
		
		WechatOrderRequest orderRequest = (WechatOrderRequest) request;
		
		
		try {
			
			MDataMap requestContentMap = BeanComponent.getInstance().objectToMap(orderRequest, null, false);
			
			String xmlStr = XmlUtil.getInstance().mDataMapToXml(requestContentMap);
			
			String responseMsg = WebClientComponent.doXmpRequest(configFactory.getWechatConfig().getOrderUrl(), xmlStr);
			
			orderResponse = GsonHelper.fromJson(responseMsg, orderResponse);
			
		} catch (Exception e) {
			
			orderResponse.setReturn_code(WechatUnifyResultCodeEnum.FAIL.name());
			
			orderResponse.setReturn_msg(e.getMessage());
			
		}
		
		return orderResponse;
	}
	

	@Override
	public WechatOrderRequest initOrderRequest(WechatBizContentRequest bizContentRequest,PayProcessEnum processEnum){
		
		WechatOrderRequest orderRequest = new WechatOrderRequest();
		
		orderRequest.setAppid(configFactory.getWechatConfig().getAppId(processEnum));
		
		orderRequest.setBody(bizContentRequest.getBody());
		
		orderRequest.setMch_id(configFactory.getWechatConfig().getMchId(processEnum));
		
		orderRequest.setNoncestr(WechatUtil.getNonceStr());
		
		String notifyUrl = bizContentRequest.getRequestIP() + configFactory.getWechatConfig().getNotifyUrl();
		
		orderRequest.setNotify_url(notifyUrl);
		
		orderRequest.setOut_trade_no(bizContentRequest.getOrderCode());
		
		orderRequest.setTime_expire(DateFormatUtils.format(bizContentRequest.getTime_expire(), "yyyyMMddHHmmss"));
		
		orderRequest.setTime_start(DateFormatUtils.format(bizContentRequest.getTime_start(), "yyyyMMddHHmmss"));
		
		orderRequest.setTrade_type(configFactory.getWechatConfig().getTradeType());
		
		orderRequest.setSpbill_create_ip(bizContentRequest.getRomoteIp());
		
		try {
			
			MDataMap mDataMap = BeanComponent.getInstance().objectToMap(orderRequest, null, false);
			
			String sign = configFactory.getWechatConfig().getSign(mDataMap,processEnum);
			
			orderRequest.setSign(sign);
			
		} catch (Exception e) {
			
			orderRequest = null;
			
		}
		
		return orderRequest;
		
	}

}
