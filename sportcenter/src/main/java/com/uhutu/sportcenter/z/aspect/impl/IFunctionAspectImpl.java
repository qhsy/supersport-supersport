package com.uhutu.sportcenter.z.aspect.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.aspect.IFunctionAspect;

/**
 * 操作日志切面接口处理
 * 
 * @author xiegj
 *
 */
@Component
@Aspect
public class IFunctionAspectImpl implements IFunctionAspect {

	@Pointcut("execution(* com.uhutu.dcom..*.*(..))")
	public void pointAround() {
	}

	@Override
	@Around("pointAround()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("--------------------------------------------------");

		return joinPoint.proceed();

	}

}
