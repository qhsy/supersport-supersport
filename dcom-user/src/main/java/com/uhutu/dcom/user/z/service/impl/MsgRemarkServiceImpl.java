package com.uhutu.dcom.user.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public int queryCount(String userCode, String flag) {
		
		return userDaoFacotry.getMsgRemarkDao().queryCount(userCode, flag);
	}

}
