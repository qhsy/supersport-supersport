package com.uhutu.dcom.content.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 运动业务逻辑工厂类
 * 
 * @author xiegj
 *
 */
@Component
public class ContentSportServiceFactory {

	@Autowired
	private IContentSportService contentSportService;

	public IContentSportService getContentSportService() {
		return contentSportService;
	}

}
