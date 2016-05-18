package com.uhutu.dcom.user.z.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public int queryCount(String userCode, String flag) {
		
		return userDaoFacotry.getMsgNoticeUserDao().queryCount(userCode, flag);
		
	}

}
