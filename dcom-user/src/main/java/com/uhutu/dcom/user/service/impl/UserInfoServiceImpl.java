package com.uhutu.dcom.user.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhutu.dcom.user.dao.UserDaoFacotry;
import com.uhutu.dcom.user.entity.UcUserinfo;
import com.uhutu.dcom.user.service.IUserInfoService;

/**
 * 用户业务处理实现
 * @author pang_jhui
 *
 */
@Service
@Transactional(readOnly = true)
public class UserInfoServiceImpl implements IUserInfoService {
	
	@Autowired
	private UserDaoFacotry userDaoFacotry;

	@Override
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void save(UcUserinfo ucUserinfo) {
		
		userDaoFacotry.getUserInfoDao().save(ucUserinfo);
		
	}
	
	@Override
	public UcUserinfo query(String id){
		
		return userDaoFacotry.getUserInfoDao().findOne(id);
		
	}

}
