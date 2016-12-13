package com.uhutu.dcom.user.z.service.impl;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.user.z.entity.UcAccountInfo;
import com.uhutu.dcom.user.z.service.IAccountInfoService;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 账户信息业务实现
 * @author 逄小帅
 *
 */
@Component
public class AccountInfoServiceImpl implements IAccountInfoService {

	@Override
	public UcAccountInfo getAccountInfo(String userCode) {
		
		UcAccountInfo accountInfo = JdbcHelper.queryOne(UcAccountInfo.class, "userCode",userCode);
		
		return accountInfo;
	}

	@Override
	public void regAccInfo(String userCode) {
		
		UcAccountInfo accountInfo = new UcAccountInfo();
		
		accountInfo.setUserCode(userCode);
		
		JdbcHelper.insert(accountInfo);
		
	}

	@Override
	public void updateAccInfo(UcAccountInfo accInfo) {
		
		JdbcHelper.update(accInfo, "profit,totalProfit,balance,charge,freeze", "za");
		
	}

}
