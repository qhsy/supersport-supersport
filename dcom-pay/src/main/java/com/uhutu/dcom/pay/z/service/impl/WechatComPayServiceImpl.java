package com.uhutu.dcom.pay.z.service.impl;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.service.IWechatComPayService;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 微信企业支付业务
 * @author 逄小帅
 *
 */
@Service
public class WechatComPayServiceImpl implements IWechatComPayService {

	@Override
	public IPayResponse doProcess(IPayRequest request, MDataMap paramMap) {
		
		
		
		return null;
	}

}
