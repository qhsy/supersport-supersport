package com.uhutu.dcom.answer.z.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.answer.z.common.AnswerEnum;
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
		
		String whereStr = "status<>'"+AnswerEnum.STATUS_UNPAY.getCode()+"'";
		
		whereStr = whereStr + " and questionUserCode = '"+userCode+"'";
		
		return JdbcHelper.count(AwQuestionInfo.class, whereStr, MapHelper.initMap("questionUserCode",userCode));
		
	}

	@Override
	public List<AwQuestionInfo> queryList(String userCode,int iStart, int iNumber) {
		
		String whereStr = "status<>'"+AnswerEnum.STATUS_UNPAY.getCode()+"'";
		
		whereStr = whereStr + " and questionUserCode = '"+userCode+"'";
		
		return JdbcHelper.queryForList(AwQuestionInfo.class, "", "", whereStr, MapHelper.initMap("questionUserCode",userCode), iStart, iNumber);
	}

	@Override
	public int queryAnswerCount(String userCode, String status) {
		
		MDataMap mWhereMap = new MDataMap();
		
		String whereStr = "";
		
		mWhereMap.put("answerUserCode", userCode);
		
		if(StringUtils.isNotBlank(status)){
			
			mWhereMap.put("status", status);
			
		}else{
			
			whereStr = "status<>'"+AnswerEnum.STATUS_UNPAY.getCode()+"'";
			
			whereStr = whereStr + " and answerUserCode = '"+userCode+"'";
			
		}
		
		return JdbcHelper.count(AwQuestionInfo.class, whereStr, mWhereMap);
		
	}

	@Override
	public List<AwQuestionInfo> queryAnswerList(String userCode, String status, int iStart, int iNumber) {
		
		MDataMap mWhereMap = new MDataMap();
		
		String whereStr = "";
		
		mWhereMap.put("answerUserCode", userCode);
		
		if(StringUtils.isNotBlank(status)){
			
			mWhereMap.put("status", status);
			
		}else{
			
			whereStr = "status<>'"+AnswerEnum.STATUS_UNPAY.getCode()+"'";
			
			whereStr = whereStr + " and answerUserCode = '"+userCode+"'";
			
		}
		
		return JdbcHelper.queryForList(AwQuestionInfo.class, "", "", whereStr, mWhereMap, iStart, iNumber);
	}

	@Override
	public AwQuestionInfo queryByCode(String code) {
		
		return JdbcHelper.queryOne(AwQuestionInfo.class, "code",code);
	}

	@Override
	public int updateStatus(AwQuestionInfo awQuestionInfo) {
		
		return JdbcHelper.update(awQuestionInfo, "status", "code");
	}
	
	
	

}
