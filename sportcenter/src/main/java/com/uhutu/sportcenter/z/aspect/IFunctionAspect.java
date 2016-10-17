package com.uhutu.sportcenter.z.aspect;

import org.aspectj.lang.JoinPoint;

import com.uhutu.zooweb.api.webpage.WebOperateResult;

/**
 * 操作日志切面接口
 * 
 * @author xiegj
 *
 */
public interface IFunctionAspect {

	/**
	 * 环绕按钮操作
	 * 
	 * @param joinPoint
	 *            切入点
	 * @throws Throwable
	 */
	public WebOperateResult doAround(JoinPoint joinPoint) throws Throwable;

}
