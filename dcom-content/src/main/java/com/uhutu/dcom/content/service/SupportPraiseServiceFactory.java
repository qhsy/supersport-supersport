package com.uhutu.dcom.content.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 点赞业务处理
 * 
 * @author xiegj
 *
 */
@Component
public class SupportPraiseServiceFactory {

	@Autowired
	private ISupportPraiseService supportPraiseService;

	public ISupportPraiseService getSupportPraiseService() {
		return supportPraiseService;
	}

}
