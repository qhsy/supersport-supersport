package com.uhutu.dcom.content.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 评论信息逻辑工厂类
 * 
 * @author xiegj
 *
 */
@Component
public class ContentRemarkServiceFactory {

	@Autowired
	private IContentRemarkService  contentRemarkService;

	public IContentRemarkService getContentRemarkService() {
		return contentRemarkService;
	}

}
