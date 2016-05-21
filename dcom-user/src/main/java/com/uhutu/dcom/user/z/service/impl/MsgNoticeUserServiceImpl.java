package com.uhutu.dcom.user.z.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.page.QueryConditionUtil;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcMsgNoticeUser;
import com.uhutu.dcom.user.z.service.IMsgNoticeUserService;

/**
 * 消息通知与用户关联service
 * @author 逄小帅
 *
 */
@Service
public class MsgNoticeUserServiceImpl implements IMsgNoticeUserService {
	
	@Autowired
	private UserDaoFacotry userDaoFacotry;

	@Override
	public void save(List<UcMsgNoticeUser> msgNoticeUsers) {
		
		userDaoFacotry.getMsgNoticeUserDao().save(msgNoticeUsers);

	}

	@Override
	public int queryCount(String userCode, String status) {
		
		return userDaoFacotry.getMsgNoticeUserDao().queryCount(userCode, status);
		
	}

	@Override
	public Page<UcMsgNoticeUser> queryPageByUserCode(int pageNum, int limit, QueryConditions conditions) {
		
		if(pageNum >= 1){
			
			pageNum--;
			
		}
		
		PageRequest page = new PageRequest(pageNum, limit);
		
		Specification<UcMsgNoticeUser> spec = QueryConditionUtil.buildSpecification(conditions);
		
		Page<UcMsgNoticeUser> msgNoticePage = userDaoFacotry.getMsgNoticeUserDao().findAll(spec, page);
		
		return msgNoticePage;
		
	
	}

}
