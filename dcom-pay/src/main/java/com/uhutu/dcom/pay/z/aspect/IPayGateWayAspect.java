package com.uhutu.dcom.pay.z.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import com.uhutu.dcom.pay.z.face.IPayAspect;
import com.uhutu.dcom.pay.z.face.IPayResponse;

/**
 * 支付网关切面接口
 * @author 逄小帅
 *
 */
public interface IPayGateWayAspect extends IPayAspect {
	
	/**
	 * 环绕支付网关
	 * @param joinPoint
	 * 		切入点
	 * @throws Throwable 
	 */
	public IPayResponse doAround(ProceedingJoinPoint joinPoint) throws Throwable;



}
