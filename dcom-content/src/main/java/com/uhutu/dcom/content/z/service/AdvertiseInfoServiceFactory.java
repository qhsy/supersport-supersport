package com.uhutu.dcom.content.z.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 内容基本信息逻辑工厂类
 * 
 * @author xiegj
 *
 */
@Component
public class AdvertiseInfoServiceFactory {

	@Autowired
	private IAdvertiseInfoService advertiseInfoService;

	public IAdvertiseInfoService getAdvertiseInfoService() {
		return advertiseInfoService;
	}

}
