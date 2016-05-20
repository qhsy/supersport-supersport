package com.uhutu.dcom.user.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.uhutu.dcom.component.z.page.QueryConditionUtil;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcMsgPraise;
import com.uhutu.dcom.user.z.service.IMsgPraiseService;

/**
 * 点赞消息service实现
 * @author 逄小帅
 *
 */
@Service
public class MsgPraiseServiceImpl implements IMsgPraiseService {
	
	@Autowired
	private UserDaoFacotry userDaoFacotry;

	@Override
	public void save(UcMsgPraise ucMsgPraise) {
		
		userDaoFacotry.getMsgPraiseDao().save(ucMsgPraise);
		
	}

	@Override
	public int queryCount(String userCode, String status) {
		
		return userDaoFacotry.getMsgPraiseDao().queryCount(userCode, status);
	}

	@Override
	public Page<UcMsgPraise> queryPageByUserCode(int pageNum, int limit, QueryConditions conditions) {
		
		if(pageNum >= 1){
			
			pageNum--;
			
		}
		
		PageRequest page = new PageRequest(pageNum, limit);
		
		Specification<UcMsgPraise> spec = QueryConditionUtil.buildSpecification(conditions);
		
		Page<UcMsgPraise> msgPraisePage = userDaoFacotry.getMsgPraiseDao().findAll(spec, page);
		
		return msgPraisePage;
		
	}

}
