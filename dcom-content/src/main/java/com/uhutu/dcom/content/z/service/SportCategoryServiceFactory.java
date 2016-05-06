package com.uhutu.dcom.content.z.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 运动类型业务逻辑工厂类
 * 
 * @author xiegj
 *
 */
@Component
public class SportCategoryServiceFactory {

	@Autowired
	private ISportCategoryService sportCategoryService;

	public ISportCategoryService getSportCategoryService() {
		return sportCategoryService;
	}

}
