package com.uhutu.dcom.content.z.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 栏目业务逻辑工厂类
 * 
 * @author xiegj
 *
 */
@Component
public class ContentItemServiceFactory {

	@Autowired
	private IContentItemService contentItemService;

	public IContentItemService getContentItemService() {
		return contentItemService;
	}

}
