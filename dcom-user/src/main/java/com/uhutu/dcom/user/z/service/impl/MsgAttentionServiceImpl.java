package com.uhutu.dcom.user.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcMsgAttention;
import com.uhutu.dcom.user.z.service.IMsgAttentionService;

/**
 * 关注消息通知service实现
 * @author 逄小帅
 *
 */
@Service
public class MsgAttentionServiceImpl implements IMsgAttentionService {
	
	@Autowired
	private UserDaoFacotry userDaoFacotry;

	@Override
	public void save(UcMsgAttention ucMsgAttention) {
		
		userDaoFacotry.getMsgAttentionDao().save(ucMsgAttention);

	}

}
