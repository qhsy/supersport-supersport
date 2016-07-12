package com.uhutu.dcom.pay.z.aspect.impl;

import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.pay.z.aspect.IPayGateWayAspect;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 支付相关日志记录、通用业务处理
 * @author pang_jhui
 *
 */
@Component
@Aspect
public class PayGateWayAspectImpl implements IPayGateWayAspect {

	//@Pointcut("execution(* com.uhutu.dcom.pay.z.service.impl.*NotifyServiceImpl.doProcess(..))")
	public void pointOut(){}
	
	@Override
	//@Around("pointOut()")
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
