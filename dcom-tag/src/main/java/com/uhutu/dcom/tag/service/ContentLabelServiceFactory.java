package com.uhutu.dcom.tag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 标签业务处理
 * 
 * @author xiegj
 *
 */
@Component
public class ContentLabelServiceFactory {

	@Autowired
	private IContentLabelService contentLabelService;

	public IContentLabelService getContentLabelService() {
		return contentLabelService;
	}

}
