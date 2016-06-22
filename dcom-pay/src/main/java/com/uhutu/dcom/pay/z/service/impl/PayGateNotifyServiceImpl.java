package com.uhutu.dcom.pay.z.service.impl;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.service.IPayGateNotifyService;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 支付网关回调业务实现
 * @author 逄小帅
 *
 */
@Service
public class PayGateNotifyServiceImpl implements IPayGateNotifyService {

	@Override
	public IPayResponse doProcess(IPayRequest request,MDataMap paramMap) {
		
		return null;
		
	}

}
