package com.uhutu.sportcenter.z.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

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
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable;

}
