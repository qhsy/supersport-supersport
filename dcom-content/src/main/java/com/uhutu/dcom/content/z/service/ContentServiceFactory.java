package com.uhutu.dcom.content.z.service;

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
	
	@Autowired
	private IContentPhotosService contentPhotosService;
	
	@Autowired
	private IContentRecommService contentRecommService;
	
	@Autowired
	private ISupportPraiseService supportPraiseService;

	public IContentPhotosService getContentPhotosService() {
		return contentPhotosService;
	}

	public IContentBasicinfoService getContentBasicinfoService() {
		return contentBasicinfoService;
	}

	public IContentDetailService getContentDetailService() {
		return contentDetailService;
	}

	public IContentRecommService getContentRecommService() {
		return contentRecommService;
	}

	public ISupportPraiseService getSupportPraiseService() {
		return supportPraiseService;
	}

}
