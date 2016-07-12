package com.uhutu.dcom.pay.z.aspect.impl;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.pay.z.aspect.IPayGateWayAspect;
import com.uhutu.dcom.pay.z.common.Constants;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.entity.PaInclogInfo;
import com.uhutu.dcom.pay.z.face.IPayRequest;
import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.zoocom.helper.GsonHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;

/**
 * 支付相关日志记录、通用业务处理
 * @author pang_jhui
 *
 */
@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class PayGateWayAspectImpl implements IPayGateWayAspect {

	@Pointcut("execution(* com.uhutu.dcom.pay.z.process.impl.PayGateProcess.process(..))")
	public void pointOut(){}
	
	@Override
	@Around("pointOut()")
	public IPayResponse doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Object[] args = joinPoint.getArgs();
		
		PayProcessEnum processEnum = (PayProcessEnum) args[0];
		
		IPayRequest payRequest = (IPayRequest) args[1];
		
		MDataMap mDataMap = (MDataMap) args[2];
		
		String busiCode = mDataMap.get(Constants.KEY_BUSICODE);
		
		if(StringUtils.isBlank(busiCode)){
			
			busiCode = WebHelper.upCode("Log");
			
		}
		
		String remark = mDataMap.get(Constants.KEY_REMARK);
		
		PaInclogInfo inclogInfo = new PaInclogInfo();
		
		inclogInfo.setBusiCode(busiCode);
		
		inclogInfo.setIncType(processEnum.name());
		
		inclogInfo.setRemark(remark);
		
		String requestData = GsonHelper.toJson(payRequest);
		
		IPayResponse payResponse = (IPayResponse) joinPoint.proceed();
		
		String responseData = GsonHelper.toJson(payResponse);
		
		inclogInfo.setRequestData(requestData);
		
		inclogInfo.setResponseData(responseData);
		
		JdbcHelper.insert(inclogInfo);
		
		return payResponse;
		
	}


}
