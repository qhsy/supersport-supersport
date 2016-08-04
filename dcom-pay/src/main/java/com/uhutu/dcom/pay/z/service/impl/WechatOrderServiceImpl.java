package com.uhutu.dcom.pay.z.service.impl;

import java.math.BigDecimal;

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
import com.uhutu.dcom.pay.z.request.WechatUnifyRequest;
import com.uhutu.dcom.pay.z.response.WechatOrderResponse;
import com.uhutu.dcom.pay.z.service.IWechatOrderService;
import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.dcom.pay.z.util.WechatUtil;
import com.uhutu.dcom.pay.z.util.XmlUtil;
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
			
			MDataMap requestContentMap = BeanComponent.getInstance().objectToMap(orderRequest, WechatUnifyRequest.class, true);
			
			String xmlStr = XmlUtil.getInstance().mDataMapToXml(requestContentMap);
			
			xmlStr = new String(xmlStr.getBytes(),"ISO8859-1");
			
			String responseMsg = WebClientComponent.doXmpRequest(configFactory.getWechatConfig().getOrderUrl(), xmlStr);
			
			MDataMap mdDataMap = XmlUtil.getInstance().xmlToMDataMap(responseMsg);
			
			orderResponse = BeanComponent.getInstance().invoke(orderResponse.getClass(), mdDataMap, true);
			
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
		
		orderRequest.setBody("果冻体育-"+"问答支付");
		
		orderRequest.setMch_id(configFactory.getWechatConfig().getMchId(processEnum));
		
		orderRequest.setNonce_str(WechatUtil.getNonceStr());
		
		String notifyUrl = bizContentRequest.getRequestIP() + configFactory.getWechatConfig().getWechatNotifyUrl(processEnum);
		
		orderRequest.setNotify_url(notifyUrl);
		
		orderRequest.setOut_trade_no(bizContentRequest.getOrderCode());
		
		if(bizContentRequest.getTime_expire() != null){
			
			orderRequest.setTime_expire(DateFormatUtils.format(bizContentRequest.getTime_expire(), "yyyyMMddHHmmss"));
			
		}
		
		if(bizContentRequest.getTime_start() != null){
			
			orderRequest.setTime_start(DateFormatUtils.format(bizContentRequest.getTime_start(), "yyyyMMddHHmmss"));
			
		}
		
		orderRequest.setTotal_fee(bizContentRequest.getPayMoney().multiply(new BigDecimal(100)).setScale(2).intValue());
		
		orderRequest.setTrade_type(configFactory.getWechatConfig().getTradeType(processEnum));
		
		orderRequest.setSpbill_create_ip(bizContentRequest.getRomoteIp());
		
		orderRequest.setOpenid(bizContentRequest.getOpenid());
		
		try {
			
			MDataMap mDataMap = BeanComponent.getInstance().objectToMap(orderRequest, WechatUnifyRequest.class, true);
			
			String sign = configFactory.getWechatConfig().getSign(mDataMap,processEnum);
			
			orderRequest.setSign(sign);
			
		} catch (Exception e) {
			
			orderRequest = null;
			
		}
		
		return orderRequest;
		
	}

}
