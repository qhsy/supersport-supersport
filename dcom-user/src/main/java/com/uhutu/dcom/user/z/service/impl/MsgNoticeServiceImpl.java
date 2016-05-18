package com.uhutu.dcom.user.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcMsgNotice;
import com.uhutu.dcom.user.z.service.IMsgNoticeService;

/**
 * 消息通知业务实现
 * @author 逄小帅
 *
 */
@Service
public class MsgNoticeServiceImpl implements IMsgNoticeService {
	
	@Autowired
	private UserDaoFacotry userDaoFacotry;

	@Override
	public void save(UcMsgNotice ucMsgNotice) {
		
		userDaoFacotry.getMsgNoticeDao().save(ucMsgNotice);

	}

}
