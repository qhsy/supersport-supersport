package com.uhutu.dcom.user.z.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
		
		if (StringUtils.isNoneBlank(ucMsgNotice.getZa()) && userDaoFacotry.getUserInfoDao().exists(ucMsgNotice.getZa())) {

			ucMsgNotice.setZu(new Date());

			userDaoFacotry.getMsgNoticeDao().save(ucMsgNotice);

		} else {

			ucMsgNotice.setZc(new Date());

			userDaoFacotry.getMsgNoticeDao().save(ucMsgNotice);

		}

	}

	@Override
	public UcMsgNotice queryByCode(String code) {
		
		return userDaoFacotry.getMsgNoticeDao().queryByCode(code);
	}

	@Override
	public List<UcMsgNotice> queryUnReadMsgList(String userCode) {
		
		return userDaoFacotry.getMsgNoticeDao().queryUnReadMsgList(userCode);
		
	}

}
