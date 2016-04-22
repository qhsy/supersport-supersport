package com.uhutu.dcom.content.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 内容业务逻辑工厂类
 * 
 * @author xiegj
 *
 */
@Component
public class ContentDetailServiceFactory {

	@Autowired
	private IContentDetailService contentDetailService;

	public IContentDetailService getContentDetailService() {
		return contentDetailService;
	}

}
