package com.uhutu.dcom.user.z.support;

import org.springframework.stereotype.Component;

/**
 * 账户操作support
 * @author 逄小帅
 *
 */
@Component
public class AccountComponet {
	
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
					
					INSTANCE = new AccountComponet();
					
				}
				
			}
			
		}
		
		return INSTANCE;
		
	}

}
