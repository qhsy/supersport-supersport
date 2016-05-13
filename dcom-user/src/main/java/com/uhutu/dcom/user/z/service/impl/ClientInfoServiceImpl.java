package com.uhutu.dcom.user.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcClientInfo;
import com.uhutu.dcom.user.z.service.IClientInfoService;

@Service
public class ClientInfoServiceImpl implements IClientInfoService {

	@Autowired
	private UserDaoFacotry userDaoFacotry;

	@Override
	public void save(UcClientInfo clientInfo) {
		userDaoFacotry.getClientInfoDao().save(clientInfo);
	}

}
