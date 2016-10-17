package com.uhutu.sportcenter.z.aspect.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.aspect.IFunctionAspect;
import com.uhutu.zooweb.api.webpage.WebOperateResult;

/**
 * 操作日志切面接口处理
 * 
 * @author xiegj
 *
 */
@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class IFunctionAspectImpl implements IFunctionAspect {

	@Pointcut("execution(* *..*Func*.process(..))")
	public void pointAround() {
	}

	@Override
	@After("pointAround()")
	public WebOperateResult doAround(JoinPoint joinPoint) throws Throwable {

		System.out.println("success");

		return null;

	}

}
