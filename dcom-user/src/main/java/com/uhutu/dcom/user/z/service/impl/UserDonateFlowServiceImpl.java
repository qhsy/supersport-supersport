package com.uhutu.dcom.user.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcDonateFlow;
import com.uhutu.dcom.user.z.service.IUserDonateFlowService;

/**
 * 捐赠流水业务实现
 * @author 逄小帅
 *
 */
@Service
public class UserDonateFlowServiceImpl implements IUserDonateFlowService {
	
	@Autowired
	private UserDaoFacotry userDaoFactory;

	@Override
	public void save(UcDonateFlow donateFlow) {
	
		 userDaoFactory.getUserDonateFlowDao().save(donateFlow);

	}

}
