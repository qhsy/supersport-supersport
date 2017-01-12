package com.uhutu.dcom.search.z.client.component;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import com.aliyun.opensearch.CloudsearchClient;
import com.aliyun.opensearch.object.KeyTypeEnum;
import com.uhutu.dcom.search.z.client.config.CloudSearchConfig;

/**
 * solr客户端 共用组件
 * @author 逄小帅
 *
 */

public class CloudSearchComponent {
	
	/*实体bean处理处理实例*/
	private volatile static CloudSearchComponent INSTANCE = null;
	
	/**
	 * 获取实体bean处理实例
	 * @return AccountComponet
	 */
	public static CloudSearchComponent getInstance(){
		
		if(INSTANCE == null){
			
			synchronized (CloudSearchComponent.class) {
				
				if(INSTANCE == null){
					
					INSTANCE = new CloudSearchComponent();
					
				}
				
			}
			
		}
		
		return INSTANCE;
		
	}
	
	public CloudsearchClient getCloudSerachClient() throws UnknownHostException{
		
		Map<String, Object> opts = new HashMap<String, Object>();
		
		return new CloudsearchClient(CloudSearchConfig.AK_ID, CloudSearchConfig.AK_SECRET, CloudSearchConfig.HOST, opts, KeyTypeEnum.ALIYUN);
		
	}
	
}
