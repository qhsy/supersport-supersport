package com.uhutu.dcom.answer.z.dao.impl;

import org.springframework.stereotype.Repository;

import com.uhutu.dcom.answer.z.dao.IAwAnswerExpertDao;
import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 问答用户信息dao
 * @author 逄小帅
 *
 */
@Repository
public class AwAnswerExpertDaoImpl implements IAwAnswerExpertDao {

	@Override
	public AwAnswerExpert queryByCode(String userCode) {
		
		return JdbcHelper.queryOne(AwAnswerExpert.class, "userCode",userCode);
		
	}

}
