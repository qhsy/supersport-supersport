package com.uhutu.dcom.pay.z.aspect.impl;

import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import com.uhutu.dcom.pay.z.aspect.IPayGateWayAspect;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 支付网关相关信息处理
 * @author pang_jhui
 *
 */
@Aspect
public class PayGateWayAspectImpl implements IPayGateWayAspect {
	
	public static final String POINTCUT = "execution(* com.uhutu.dcom.pay.z.service.impl.*NotifyServiceImpl.doProcess*(..))";

	@Override
	@Around(POINTCUT)
	public IPayResponse doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		
		return null;
		
	}

	@Override
	public Map<String,Object> doProcessBefore(IPayRequest payGateWayRequest, MDataMap mDataMap) {
		
		return null;
	}

	@Override
	public void doProcessAfter(IPayRequest payGateWayRequest, MDataMap mDataMap) {
		
		
		
	}
	
	
	


}
