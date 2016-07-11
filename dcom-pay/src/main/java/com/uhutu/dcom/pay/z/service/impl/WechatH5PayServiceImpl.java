package com.uhutu.dcom.pay.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.config.WechatConfig;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.request.WechatH5PayRequest;
import com.uhutu.dcom.pay.z.response.WechatH5PayResponse;
import com.uhutu.dcom.pay.z.service.IWechatH5PayService;
import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.dcom.pay.z.util.WechatUtil;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 微信h5支付业务实现
 * @author 逄小帅
 *
 */
@Service
public class WechatH5PayServiceImpl implements IWechatH5PayService {
	
	@Autowired
	private WechatConfig wechatConfig;

	@Override
	public IPayResponse doProcess(IPayRequest request, MDataMap paramMap) {
		
		WechatH5PayRequest h5Request = (WechatH5PayRequest) request;

		return initH5Response(h5Request.getPrePayId());
		
	}
	
	public WechatH5PayResponse initH5Response(String prepayId){
		
		WechatH5PayResponse h5PayResponse = new WechatH5PayResponse();
		
		h5PayResponse.setAppId(wechatConfig.getAppId(PayProcessEnum.WECHAT_SERVICE_CONFIG));
		
		h5PayResponse.setNonceStr(WechatUtil.getNonceStr());
		
		h5PayResponse.setSignType("MD5");
		
		h5PayResponse.setTimeStamp(WechatUtil.getTimeStamp());
		
		try {
			MDataMap mDataMap = BeanComponent.getInstance().objectToMap(h5PayResponse, null, false);
			
			mDataMap.put("package", "prepay_id="+prepayId);
			
			String sign = wechatConfig.getSign(mDataMap,PayProcessEnum.WECHAT_SERVICE_CONFIG);
			
			h5PayResponse.setPaySign(sign);
			
			h5PayResponse.setPrepay_id(prepayId);
			
		} catch (Exception e) {
			
			h5PayResponse = null;
			
		}
		
		return h5PayResponse;
		
	}
	
	

}
