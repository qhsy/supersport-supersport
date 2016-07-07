package com.uhutu.dcom.pay.z.service.impl;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uhutu.dcom.component.z.util.WebClientComponent;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.common.WechatUnifyResultCodeEnum;
import com.uhutu.dcom.pay.z.config.PayConfigFactory;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.request.WechatComPayBizRequest;
import com.uhutu.dcom.pay.z.request.WechatComPayRequest;
import com.uhutu.dcom.pay.z.response.WechatComPayResponse;
import com.uhutu.dcom.pay.z.service.IWechatComPayService;
import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.dcom.pay.z.util.WechatUtil;
import com.uhutu.dcom.pay.z.util.XmlUtil;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 微信企业支付业务
 * @author 逄小帅
 *
 */
@Service
public class WechatComPayServiceImpl implements IWechatComPayService {
	
	@Autowired
	private PayConfigFactory configFactory;

	@Override
	public IPayResponse doProcess(IPayRequest request, MDataMap paramMap) {
		
		WechatComPayBizRequest bizRequest = (WechatComPayBizRequest) request;
		
		WechatComPayRequest payRequest = initPayRequest(bizRequest);
		
		WechatComPayResponse payResponse = new WechatComPayResponse();
		
		try {
			
			MDataMap requestMap = BeanComponent.getInstance().objectToMap(payRequest, null, false);
		
			String sign = configFactory.getWechatConfig().getSign(requestMap, PayProcessEnum.WECHAT_SERVICE_CONFIG);
			
			requestMap.put("sign", sign);
			
			String xmlStr = XmlUtil.getInstance().mDataMapToXml(requestMap);
			
			String responseMsg = WebClientComponent.doXmpRequest(configFactory.getWechatConfig().getServiceComPayUrl(), xmlStr);
			
			MDataMap responseMap = XmlUtil.getInstance().xmlToMDataMap(responseMsg);
			
			payResponse = BeanComponent.getInstance().invoke(payResponse.getClass(), responseMap, true);			
			
		} catch (Exception e) {
			
			payResponse.setReturn_code(WechatUnifyResultCodeEnum.FAIL.name());
			
			payResponse.setReturn_msg(e.getMessage());
			
		}
		
		return payResponse;
	}
	
	/**
	 * 初始化支付请求
	 * @param bizRequest
	 * 		业务请求
	 * @return 企业支付请求
	 */
	public WechatComPayRequest initPayRequest(WechatComPayBizRequest bizRequest){
		
		WechatComPayRequest payRequest = new WechatComPayRequest();
		
		int amount = bizRequest.getAmount().multiply(new BigDecimal(100)).intValue();
		
		payRequest.setAmount(amount);
		
		payRequest.setDesc(bizRequest.getRemark());
		
		payRequest.setMch_appid(configFactory.getWechatConfig().getServiceAppId());
		
		payRequest.setNonce_str(WechatUtil.getNonceStr());
		
		payRequest.setOpenid(bizRequest.getOpenid());
		
		payRequest.setPartner_trade_no(bizRequest.getOrderCode());
		
		payRequest.setSpbill_create_ip(bizRequest.getRomoteIP());
		
		return payRequest;
		
	}

}
