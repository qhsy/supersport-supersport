package com.uhutu.dcom.answer.z.dao.impl;

import org.springframework.stereotype.Repository;

import com.uhutu.dcom.answer.z.dao.IAwAnswerExpertDao;
import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.zoocom.helper.MapHelper;
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

	@Override
	public int save(AwAnswerExpert expert) {
		
		int result = 0;
		
		int count = JdbcHelper.count(AwAnswerExpert.class, "", MapHelper.initMap("userCode",expert.getUserCode()));
		
		if(count > 0){
			
			result = JdbcHelper.update(expert, "charge,ability,title", "userCode");
			
		}else{
			
			result = JdbcHelper.insert(expert);
			
		}
		
		return result;
		
	}

}
