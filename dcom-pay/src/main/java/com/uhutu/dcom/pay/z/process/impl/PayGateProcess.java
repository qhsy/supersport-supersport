package com.uhutu.dcom.pay.z.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.dcom.pay.z.face.IPayService;
import com.uhutu.dcom.pay.z.process.IPayGateProcess;
import com.uhutu.dcom.pay.z.service.IAlipayService;

/**
 * 支付宝业务解析
 * @author 逄小帅
 *
 */
@Component
public class PayGateProcess implements IPayGateProcess {
	
	@Autowired
	private IAlipayService alipayService;

	@Override
	public IPayResponse process(PayProcessEnum processEnum,IPayRequest request) {
		
		return upPayService(processEnum).doProcess(request);
	}
	
	@Override
	public IPayService upPayService(PayProcessEnum processEnum) {

		IPayService payService = null;

		switch (processEnum) {
		case ALIPAY:
			payService = alipayService;
			break;

		case WECHAT:
			break;

		default:
			break;
		}

		return payService;

	}
	
}
