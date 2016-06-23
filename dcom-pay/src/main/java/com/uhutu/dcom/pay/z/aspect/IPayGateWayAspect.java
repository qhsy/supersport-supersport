package com.uhutu.dcom.pay.z.aspect;

import java.util.Map;
import org.aspectj.lang.ProceedingJoinPoint;
import com.uhutu.dcom.pay.z.face.IPayAspect;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.zoocom.model.MDataMap;

/**
 * 支付网关切面接口
 * @author 逄小帅
 *
 */
public interface IPayGateWayAspect extends IPayAspect {
	
	/**
	 * 支付网关请求前执行，判断该订单是否已经支付完成
	 * @param payGateWayRequest
	 * 		支付网关请求信息
	 * @param mDataMap 扩展参数
	 * 		
	 * @return 返回参数
	 * 
	 */
	public Map<String,Object> doProcessBefore(IPayRequest payGateWayRequest, MDataMap mDataMap);
	
	/**
	 * 支付网关请求后
	 * @param payGateWayRequest
	 * 		支付网关请求信息
	 * @param mDataMap 扩展参数
	 */
	public void doProcessAfter(IPayRequest payGateWayRequest, MDataMap mDataMap);
	
	/**
	 * 环绕支付网关
	 * @param joinPoint
	 * 		切入点
	 * @throws Throwable 
	 */
	public IPayResponse doAround(ProceedingJoinPoint joinPoint) throws Throwable;



}
