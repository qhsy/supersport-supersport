package com.uhutu.dcom.content.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 内容业务处理
 * @author pang_jhui
 *
 */
@Component
public class ContentServiceFactory {
	
	@Autowired
	private IContentBasicinfoService contentBasicinfoService;
	
	@Autowired
	private IContentDetailService contentDetailService;

	public IContentBasicinfoService getContentBasicinfoService() {
		return contentBasicinfoService;
	}

	public IContentDetailService getContentDetailService() {
		return contentDetailService;
	}

}
