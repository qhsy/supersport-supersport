package com.uhutu.dcom.answer.z.dao.impl;

import org.springframework.stereotype.Repository;

import com.uhutu.dcom.answer.z.dao.IAwSettleAccountDao;
import com.uhutu.dcom.answer.z.entity.AwSettleAccount;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;

@Repository
public class AwSettleAccountDaoImpl implements IAwSettleAccountDao {

	@Override
	public void save(AwSettleAccount awSettleAccount) {
		
		int count = JdbcHelper.count(AwSettleAccount.class, "", MapHelper.initMap("userCode",awSettleAccount.getUserCode()));
		
		if(count > 0){
			
			JdbcHelper.update(awSettleAccount, "appid,openid,accountName,type,unionid", "userCode");
			
		}else{
			
			JdbcHelper.insert(awSettleAccount);
			
		}

	}

}
