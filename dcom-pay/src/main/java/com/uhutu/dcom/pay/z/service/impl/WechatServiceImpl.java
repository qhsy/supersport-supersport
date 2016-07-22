package com.uhutu.dcom.pay.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.config.WechatConfig;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.request.WechatPayRequest;
import com.uhutu.dcom.pay.z.response.WechatPayResponse;
import com.uhutu.dcom.pay.z.service.IWechatService;
import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.dcom.pay.z.util.WechatUtil;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 微信支付业务实现
 * @author 逄小帅
 *
 */
@Service
public class WechatServiceImpl implements IWechatService {
	
	@Autowired
	private WechatConfig wechatConfig;

	@Override
	public IPayResponse doProcess(IPayRequest request,MDataMap paramMap) {
		
		WechatPayRequest payRequest = (WechatPayRequest) request;
		
		WechatPayResponse payResponse = initPayResponse(payRequest);
		
		return payResponse;
	}
	
	/**
	 * 初始化支付响应信息
	 * @param orderResponse
	 * 		订单响应信息
	 * @return 微信支付响应信息
	 */
	public WechatPayResponse initPayResponse(WechatPayRequest payRequest){
		
		WechatPayResponse payResponse = new WechatPayResponse();
		
		payResponse.setAppid(wechatConfig.getAppId());
		
		payResponse.setPartnerid(wechatConfig.getMchId());
		
		payResponse.setPrepayid(payRequest.getPrePayId());
		
		payResponse.setNoncestr(WechatUtil.getNonceStr());
		
		payResponse.setTimestamp(WechatUtil.getTimeStamp());
		
		try {
			
			MDataMap dataMap = BeanComponent.getInstance().objectToMap(payResponse, null, false);
			
			dataMap.put("package", "Sign=WXPay");
			
			String sign = wechatConfig.getSign(dataMap,PayProcessEnum.WECHAT);
			
			payResponse.setSign(sign);
			
		} catch (Exception e) {
			
			payResponse.setStatus(0);
			
			payResponse.setError(e.getMessage());
			
		}
		
		return payResponse;
		
		
	}

}
