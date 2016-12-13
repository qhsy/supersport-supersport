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

}
