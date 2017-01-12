package com.uhutu.dcom.search.z.component;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.aliyun.opensearch.CloudsearchClient;
import com.aliyun.opensearch.CloudsearchSearch;
import com.aliyun.opensearch.object.KeyTypeEnum;
import com.uhutu.dcom.search.z.config.CloudSearchConfig;

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
	
	/**
	 * 获得客户端查询实例
	 * @return
	 * 		查询客户端实例
	 * @throws UnknownHostException
	 */
	public CloudsearchClient getCloudSerachClient() throws UnknownHostException{
		
		Map<String, Object> opts = new HashMap<String, Object>();
		
		return new CloudsearchClient(CloudSearchConfig.AK_ID, CloudSearchConfig.AK_SECRET, CloudSearchConfig.HOST, opts, KeyTypeEnum.ALIYUN);
		
	}
	
	/**
	 * 单应用查询
	 * @param appName
	 * 		应用名称
	 * @param queryStr
	 * 		查询字符串
	 * @return 查询对象
	 */
	public CloudsearchSearch search(String appName, String queryStr){
		
		CloudsearchSearch cloudSearch = null;
		
		try {
			
			cloudSearch = new CloudsearchSearch(getCloudSerachClient());
			
			cloudSearch.addIndex(appName);
			
			cloudSearch.setQueryString(queryStr);
			
			cloudSearch.setFormat("json");
			
		} catch (Exception e) {
			
			cloudSearch = null;
			
			e.printStackTrace();
			
		}
		
		
		return cloudSearch;

	}
	
	/**
	 * 多应用间联合查询
	 * @param queryStr
	 * 		查询字符串
	 * @param appNames
	 * 		应用名称集合
	 * @return 查询对象
	 */
	public CloudsearchSearch unionSearch(String queryStr, String... appNames){
		
		CloudsearchSearch cloudSearch = null;
		
		try {
			
			cloudSearch = new CloudsearchSearch(getCloudSerachClient());
			
			List<String> appNameList = new ArrayList<String>();
			
			Collections.addAll(appNameList, appNames);
			
			cloudSearch.addIndex(appNameList);
			
			cloudSearch.setQueryString(queryStr);
			
			cloudSearch.setFormat("json");
			
		} catch (Exception e) {
			
			cloudSearch = null;
			
			e.printStackTrace();
			
		}
		
		
		return cloudSearch;

	}
	
}
