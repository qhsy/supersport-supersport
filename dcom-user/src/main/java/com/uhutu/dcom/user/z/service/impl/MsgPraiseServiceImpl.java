package com.uhutu.dcom.user.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public int queryCount(String userCode, String flag) {
		
		return userDaoFacotry.getMsgPraiseDao().queryCount(userCode, flag);
	}

}
