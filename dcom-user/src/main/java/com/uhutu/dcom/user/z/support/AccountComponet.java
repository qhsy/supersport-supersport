package com.uhutu.dcom.user.z.support;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.util.ApplicationSupport;
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
	
	/*实体bean处理处理实例*/
	private volatile static AccountComponet INSTANCE = null;
	
	/**
	 * 获取实体bean处理实例
	 * @return AccountComponet
	 */
	public static AccountComponet getInstance(){
		
		if(INSTANCE == null){
			
			synchronized (AccountComponet.class) {
				
				if(INSTANCE == null){
					
					INSTANCE = (AccountComponet) ApplicationSupport.getBean("accountComponet");
					
				}
				
			}
			
		}
		
		return INSTANCE;
		
	}
	
	
	/**
	 * 根据用户编号更新账户信息
	 * @param amount
	 */
	public void updateProfit(String userCode, BigDecimal amount){
		
		synchronized (AccountComponet.class) {
			
			UcAccountInfo ucAccountInfo = accountInfoService.getAccountInfo(userCode);
			
			if(ucAccountInfo != null){
				
				BigDecimal totalProfit = ucAccountInfo.getTotalProfit().add(amount).setScale(2);
				
				BigDecimal profit = ucAccountInfo.getProfit().add(amount).setScale(2);
				
				BigDecimal balance = ucAccountInfo.getBalance().add(amount).setScale(2);
				
				ucAccountInfo.setTotalProfit(totalProfit);
				
				ucAccountInfo.setProfit(profit);
				
				ucAccountInfo.setBalance(balance);
				
				accountInfoService.updateAccInfo(ucAccountInfo);
				
				
			}
			
			
		}		
		
	}
	

}
