package com.uhutu.dcom.content.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 分类业务逻辑工厂类
 * 
 * @author xiegj
 *
 */
@Component
public class ContentCategoryServiceFactory {

	@Autowired
	private IContentCategoryService contentCategoryService;

	public IContentCategoryService getContentCategoryService() {
		return contentCategoryService;
	}

}
