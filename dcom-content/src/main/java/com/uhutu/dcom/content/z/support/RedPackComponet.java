package com.uhutu.dcom.content.z.support;

import org.springframework.stereotype.Component;

/**
 * 打赏相关操作support
 * @author 逄小帅
 *
 */
@Component
public class RedPackComponet {
	
	/*实体bean处理处理实例*/
	private volatile static RedPackComponet INSTANCE = null;
	
	/**
	 * 获取实体bean处理实例
	 * @return AccountComponet
	 */
	public static RedPackComponet getInstance(){
		
		if(INSTANCE == null){
			
			synchronized (RedPackComponet.class) {
				
				if(INSTANCE == null){
					
					INSTANCE = new RedPackComponet();
					
				}
				
			}
			
		}
		
		return INSTANCE;
		
	}

}
