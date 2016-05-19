package com.uhutu.dcom.user.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.page.QueryConditionUtil;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcMsgRemark;
import com.uhutu.dcom.user.z.service.IMsgRemarkService;

/**
 * 消息评论service实现
 * @author 逄小帅
 *
 */
@Service
public class MsgRemarkServiceImpl implements IMsgRemarkService {
	
	@Autowired
	private UserDaoFacotry userDaoFacotry;

	@Override
	public void save(UcMsgRemark ucMsgRemark) {
		
		userDaoFacotry.getMsgRemarkDao().save(ucMsgRemark);

	}

	@Override
	public int queryCount(String userCode, String status) {
		
		return userDaoFacotry.getMsgRemarkDao().queryCount(userCode, status);
	}

	@Override
	public Page<UcMsgRemark> queryPageByUserCode(int pageNum, int limit, QueryConditions conditions) {
		
		if(pageNum >= 1){
			
			pageNum--;
			
		}
		
		PageRequest page = new PageRequest(pageNum, limit);
		
		Specification<UcMsgRemark> spec = QueryConditionUtil.buildSpecification(conditions);
		
		Page<UcMsgRemark> msgRemarkPage = userDaoFacotry.getMsgRemarkDao().findAll(spec, page);
		
		return msgRemarkPage;
		
	}

}
