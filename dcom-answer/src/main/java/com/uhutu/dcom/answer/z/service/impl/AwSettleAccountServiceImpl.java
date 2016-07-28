package com.uhutu.dcom.answer.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.answer.z.dao.IAwSettleAccountDao;
import com.uhutu.dcom.answer.z.entity.AwSettleAccount;
import com.uhutu.dcom.answer.z.service.IAwSettleAccountService;

/**
 * 结算账户业务实现
 * @author 逄小帅
 *
 */
@Service
public class AwSettleAccountServiceImpl implements IAwSettleAccountService {
	
	@Autowired
	private IAwSettleAccountDao settleAccountDao;

	@Override
	public void save(AwSettleAccount settleAccount) {
		
		settleAccountDao.save(settleAccount);

	}

}
