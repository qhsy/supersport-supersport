package com.uhutu.dcom.user.service.impl;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.config.enums.PrexEnum;
import com.uhutu.dcom.user.dao.UserDaoFacotry;
import com.uhutu.dcom.user.entity.UcUserinfo;
import com.uhutu.dcom.user.enums.UserEnum;
import com.uhutu.dcom.user.service.IUserInfoService;

/**
 * 用户业务处理实现
 * @author pang_jhui
 *
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
	
	@Autowired
	private UserDaoFacotry userDaoFacotry;

	@Override
	public void save(UcUserinfo ucUserinfo) {
		
		ucUserinfo.setFlag(UserEnum.FLAG_ENABLE.getCode());
		
		String dateStr = DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS");
		
		ucUserinfo.setCode(PrexEnum.UC.name()+dateStr);
		
		userDaoFacotry.getUserInfoDao().save(ucUserinfo);
		
	}
	
	@Override
	public UcUserinfo query(String id){
		
		return userDaoFacotry.getUserInfoDao().findOne(id);
		
	}

	@Override
	public UcUserinfo queryByCode(String code) {
		
		return userDaoFacotry.getUserInfoDao().queryByCode(code);
		
	}

	@Override
	public UcUserinfo queryByLoginName(String loginName) {
		
		return userDaoFacotry.getUserInfoDao().queryByLoginName(loginName);
		
	}

}
