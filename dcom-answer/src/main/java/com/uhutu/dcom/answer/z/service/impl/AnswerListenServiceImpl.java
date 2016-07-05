package com.uhutu.dcom.answer.z.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.answer.z.entity.AwAnswerListen;
import com.uhutu.dcom.answer.z.service.IAnswerListenService;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 偷听信息
 * @author 逄小帅
 *
 */
@Service
public class AnswerListenServiceImpl implements IAnswerListenService {

	@Override
	public List<AwAnswerListen> queryList(String userCode, int iStart, int iNumber) {
		
		return JdbcHelper.queryForList(AwAnswerListen.class, "", "", "", MapHelper.initMap("userCode",userCode), iStart, iNumber);
		
	}

	@Override
	public int queryCount(String userCode) {
		
		return JdbcHelper.count(AwAnswerListen.class, "", MapHelper.initMap("userCode",userCode));
	}

}
