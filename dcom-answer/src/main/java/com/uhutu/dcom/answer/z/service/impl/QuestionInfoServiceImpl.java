package com.uhutu.dcom.answer.z.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.answer.z.service.IQuestionInfoService;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.model.MDataMap;
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

	@Override
	public int queryAnswerCount(String userCode, String status) {
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("answerUserCode", userCode);
		
		if(StringUtils.isNotBlank(status)){
			
			mWhereMap.put("status", status);
			
		}
		
		return JdbcHelper.count(AwQuestionInfo.class, "", mWhereMap);
		
	}

	@Override
	public List<AwQuestionInfo> queryAnswerList(String userCode, String status, int iStart, int iNumber) {
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("answerUserCode", userCode);
		
		if(StringUtils.isNotBlank(status)){
			
			mWhereMap.put("status", status);
			
		}
		
		return JdbcHelper.queryForList(AwQuestionInfo.class, "", "", "", mWhereMap, iStart, iNumber);
	}

	@Override
	public AwQuestionInfo queryByCode(String code) {
		
		return JdbcHelper.queryOne(AwQuestionInfo.class, "code",code);
	}
	

}
