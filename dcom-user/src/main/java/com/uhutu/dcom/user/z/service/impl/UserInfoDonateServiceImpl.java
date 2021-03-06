package com.uhutu.dcom.user.z.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcUserinfoDonate;
import com.uhutu.dcom.user.z.service.IUserInfoDonateService;

@Service
public class UserInfoDonateServiceImpl implements IUserInfoDonateService {
	
	@Autowired
	private UserDaoFacotry userDaoFactory;

	@Override
	public UcUserinfoDonate queryByUserCode(String userCode) {
		
		return userDaoFactory.getUserInfoDonateDao().queryByCode(userCode);
		
	}

	@Override
	public void save(UcUserinfoDonate userInfoDonate) {

		if (StringUtils.isNotBlank(userInfoDonate.getZa())
				&& userDaoFactory.getUserInfoDonateDao().exists(userInfoDonate.getZa())) {
			
			userInfoDonate.setZu(new Date());
			
		}else{
			
			userInfoDonate.setZc(new Date());
			
		}
		
		userDaoFactory.getUserInfoDonateDao().save(userInfoDonate);

	}

}
