package com.uhutu.dcom.answer.z.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.answer.z.common.AnswerEnum;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.answer.z.service.IQuestionInfoService;
import com.uhutu.dcom.config.enums.PrexEnum;
import com.uhutu.dcom.user.z.entity.UcMsgAnswer;
import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.zoocom.helper.FormatHelper;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;

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
		
		return JdbcHelper.queryForList(AwQuestionInfo.class, "", "-question_time", whereStr, MapHelper.initMap("questionUserCode",userCode), iStart, iNumber);
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
	public List<AwQuestionInfo> queryAnswerList(String userCode, String scope, String status, int iStart, int iNumber) {
		
		MDataMap mWhereMap = new MDataMap();
		
		String whereStr = "";
		
		mWhereMap.put("answerUserCode", userCode);
		
		if(StringUtils.isNotBlank(status)){
			
			mWhereMap.put("status", status);
			
			if(StringUtils.isNotBlank(scope)){
				
				mWhereMap.put("scope", scope);
				
			}
			
		}else{
			
			whereStr = "status<>'"+AnswerEnum.STATUS_UNPAY.getCode()+"'";
			
			whereStr = whereStr + " and answerUserCode = '"+userCode+"'";
			
			if(StringUtils.isNotBlank(scope)){
				
				whereStr = whereStr + " and scope='"+scope+"'";
				
			}
			
		}
		
		return JdbcHelper.queryForList(AwQuestionInfo.class, "", "-question_time", whereStr, mWhereMap, iStart, iNumber);
	}

	@Override
	public AwQuestionInfo queryByCode(String code) {
		
		return JdbcHelper.queryOne(AwQuestionInfo.class, "code",code);
	}

	@Override
	public int updateStatus(AwQuestionInfo awQuestionInfo) {
		
		return JdbcHelper.update(awQuestionInfo, "status", "code");
	}
	
	@Override
	public void saveAnswerMsg(String title,String content,String userCode,String busiCode){
		
		UcMsgAnswer msgAnswer = new UcMsgAnswer();
		
		msgAnswer.setCode(WebHelper.upCode(PrexEnum.UAM.name()));
		
		msgAnswer.setContent(content);
		
		msgAnswer.setNotifyTime(FormatHelper.upDateTime());
		
		msgAnswer.setStatus(MsgEnum.FLAG_UNREAD.getCode());
		
		msgAnswer.setTitle(title);
		
		msgAnswer.setType("ANSWER");
		
		msgAnswer.setUserCode(userCode);
		
		msgAnswer.setBusiCode(busiCode);
		
		JdbcHelper.insert(msgAnswer);
		
	}
	

}
