package com.uhutu.dcom.answer.z.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 问答业务factory
 * @author 逄小帅
 *
 */
@Component
public class AnswerServiceFactory {
	
	@Autowired
	private IAwAnswerExpertService awAnswerExpertService;

	public IAwAnswerExpertService getAwAnswerExpertService() {
		return awAnswerExpertService;
	}

}
