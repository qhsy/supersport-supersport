package com.uhutu.dcom.user.z.support;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.user.z.entity.UcAccountInfo;
import com.uhutu.dcom.user.z.service.IAccountInfoService;

/**
 * 账户操作support
 * @author 逄小帅
 *
 */
@Component
public class AccountComponet {
	
	@Autowired
	private IAccountInfoService accountInfoService;
	
	/**
	 * 根据用户编号更新账户信息
	 * @param amount
	 */
	public void updateAccInfo(String userCode, BigDecimal amount){
		
		synchronized (AccountComponet.class) {
			
			UcAccountInfo ucAccountInfo = accountInfoService.getAccountInfo(userCode);
			
			if(ucAccountInfo != null){}
			
			
		}		
		
	}
	

}
