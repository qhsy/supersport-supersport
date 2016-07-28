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
	
	@Autowired
	private IQuestionInfoService questionInfoService;
	
	@Autowired
	private IAnswerListenService answerListenService;
	
	@Autowired
	private IAwSettleAccountService settleAccountService;

	public IAwAnswerExpertService getAwAnswerExpertService() {
		return awAnswerExpertService;
	}

	public IQuestionInfoService getQuestionInfoService() {
		return questionInfoService;
	}

	public IAnswerListenService getAnswerListenService() {
		return answerListenService;
	}

	public IAwSettleAccountService getSettleAccountService() {
		return settleAccountService;
	}

}
