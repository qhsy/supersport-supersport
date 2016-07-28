package com.uhutu.dcom.user.z.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.page.QueryConditionUtil;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcMsgAnswer;
import com.uhutu.dcom.user.z.service.IMsgAnswerService;

/**
 * 消息通知与用户关联service
 * @author 逄小帅
 *
 */
@Service
public class MsgAnswerServiceImpl implements IMsgAnswerService {
	
	@Autowired
	private UserDaoFacotry userDaoFacotry;

	@Override
	public void save(UcMsgAnswer msgAnswer) {
		
		userDaoFacotry.getMsgAnswerDao().save(msgAnswer);

	}

	@Override
	public int queryCount(String userCode, String status) {
		
		return userDaoFacotry.getMsgAnswerDao().queryCount(userCode, status);
		
	}

	@Override
	public Page<UcMsgAnswer> queryPageByUserCode(int pageNum, int limit, QueryConditions conditions) {
		
		if(pageNum >= 1){
			
			pageNum--;
			
		}
		
		Sort sort = new Sort(Direction.DESC,"zc");
		
		PageRequest page = new PageRequest(pageNum, limit,sort);
		
		Specification<UcMsgAnswer> spec = QueryConditionUtil.buildSpecification(conditions);
		
		Page<UcMsgAnswer> msgNoticePage = userDaoFacotry.getMsgAnswerDao().findAll(spec, page);
		
		return msgNoticePage;
		
	
	}

	@Override
	@Transactional
	public int updateReadStatus(String userCode, String updateStatus, String whereStatus) {
		
		return userDaoFacotry.getMsgNoticeUserDao().updateReadStatus(userCode, updateStatus, whereStatus);
		
	}

}
