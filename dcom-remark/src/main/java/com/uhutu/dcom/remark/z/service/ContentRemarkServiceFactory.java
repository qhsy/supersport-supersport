package com.uhutu.dcom.remark.z.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 内容评论业务实现
 * @author 逄小帅
 *
 */
@Component
public class ContentRemarkServiceFactory {
	
	@Autowired
	private IContentRemarkService contentRemarkService;
	
	@Autowired
	private ISupportComplainService supportComplainService;

	public IContentRemarkService getContentRemarkService() {
		return contentRemarkService;
	}

	public ISupportComplainService getSupportComplainService() {
		return supportComplainService;
	}

}
