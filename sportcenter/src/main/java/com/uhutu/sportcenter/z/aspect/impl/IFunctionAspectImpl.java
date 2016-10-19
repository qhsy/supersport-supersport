package com.uhutu.sportcenter.z.aspect.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Date;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.component.z.entity.LcWebOperInfo;
import com.uhutu.dcom.user.z.tecent.helper.JsonHelper;
import com.uhutu.zoocom.face.IRootEntity;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;

/**
 * 操作日志切面接口处理
 * 
 * @author xiegj
 *
 */
@Component
@Aspect
public class IFunctionAspectImpl {

	@Pointcut("execution(* com.uhutu.zooweb.z.controller.ContrlApiZooWeb.weboperate(..))")
	public void pointAround() {
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Around("pointAround()")
	public Object doAround(ProceedingJoinPoint joinPoint) {

		WebOperateInput input = (WebOperateInput) joinPoint.getArgs()[0];

		if (input.getPageUnique().startsWith("pa") || input.getPageUnique().startsWith("pe")
				|| input.getPageUnique().startsWith("pd")) {

			LcWebOperInfo lcWebOperInfo = new LcWebOperInfo();

			lcWebOperInfo.setZc(new Date());

			lcWebOperInfo.setUserToken(input.getZoo().getToken());

			lcWebOperInfo.setPageUrl(input.getPageUrl());

			lcWebOperInfo.setPageUnique(input.getPageUnique());

			lcWebOperInfo.setOperateCode(input.getOperateCode());

			JsonHelper<MDataMap> helper = new JsonHelper<MDataMap>();

			lcWebOperInfo.setOperData(helper.GsonToJson(input.getDataMap()));

			String za = input.getDataMap().get("za");

			if (StringUtils.isNotEmpty(za)) {

				Class clazz = initClass(input.getPageUnique());

				Object object = JdbcHelper.queryOne(clazz, "za", za);

				if (object != null) {

					JsonHelper<Object> objectHelper = new JsonHelper<Object>();

					String oldData = objectHelper.GsonToJson(object);

					lcWebOperInfo.setOldData(oldData);

				}

			}

			JdbcHelper.insert(lcWebOperInfo);

		}

		try {

			return joinPoint.proceed();

		} catch (Throwable e) {

			return null;

		}

	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Class initClass(String sPageUnique){

		String[] sSplit = StringUtils.split(sPageUnique, "-");
		
		String propClassName = StringUtils.replace(sSplit[1], "_", ".");
		
		Class cEntity = null;
		
		try {
			
			Class cPageModel = ClassUtils.getClass(propClassName);
			
			ParameterizedType parameterizedType = (ParameterizedType) cPageModel.getGenericSuperclass();
			
			cEntity = (Class<IRootEntity>) (parameterizedType.getActualTypeArguments()[0]);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

		return cEntity;
		
	}

}
