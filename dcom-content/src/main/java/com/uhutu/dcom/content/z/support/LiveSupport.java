package com.uhutu.dcom.content.z.support;

import java.util.Calendar;

import com.uhutu.dcom.pay.z.util.MD5;

public class LiveSupport {
	
	/*实体bean处理处理实例*/
	private volatile static LiveSupport INSTANCE = null;
	
	/**
	 * 获取实体bean处理实例
	 * @return RedPackComponet
	 */
	public static LiveSupport getInstance(){
		
		if(INSTANCE == null){
			
			synchronized (RedPackComponet.class) {
				
				if(INSTANCE == null){
					
					INSTANCE = new LiveSupport();
					
				}
				
			}
			
		}
		
		return INSTANCE;
		
	}
	
	public String getTxTime(int amount){
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.add(Calendar.HOUR_OF_DAY, amount);
		
		long txTime = calendar.getTimeInMillis()/1000;
		
		return Long.toHexString(txTime).toUpperCase();
		
	}
	
	public String getTxSecret(String key,String steamId,String txTime){
		
		String salt = key + steamId + txTime;
		
		String txSecreat = MD5.sign(salt, "UTF-8");
		
		return txSecreat;
		
	}
	
	

}
