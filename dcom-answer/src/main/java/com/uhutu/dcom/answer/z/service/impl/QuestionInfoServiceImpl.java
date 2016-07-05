package com.uhutu.dcom.answer.z.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.answer.z.service.IQuestionInfoService;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 问题业务实现
 * @author 逄小帅
 *
 */
@Service
public class QuestionInfoServiceImpl implements IQuestionInfoService {

	@Override
	public int queryCount(String userCode) {
		
		return JdbcHelper.count(AwQuestionInfo.class, "", MapHelper.initMap("questionUserCode",userCode));
		
	}

	@Override
	public List<AwQuestionInfo> queryList(String userCode,int iStart, int iNumber) {
		
		return JdbcHelper.queryForList(AwQuestionInfo.class, "", "", "", MapHelper.initMap("questionUserCode",userCode), iStart, iNumber);
	}
	

}
