package com.uhutu.dcom.answer.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.answer.z.dao.IAwAnswerExpertDao;
import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.answer.z.service.IAwAnswerExpertService;

/**
 * 问答用户信息
 * @author 逄小帅
 *
 */
@Service
public class AwAnswerExpertServiceImpl implements IAwAnswerExpertService {
	
	@Autowired
	private IAwAnswerExpertDao awAnswerExpertDao;

	@Override
	public AwAnswerExpert getByUserCode(String userCode) {
		
		return awAnswerExpertDao.queryByCode(userCode);
		
	}

}
