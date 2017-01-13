package com.uhutu.dcom.search.z.service;

import com.uhutu.dcom.search.z.service.impl.SearchMatchServiceImpl;
import com.uhutu.dcom.search.z.service.impl.SearchUserServiceImpl;
import com.uhutu.dcom.search.z.service.impl.SearchVideoServiceImpl;

/**
 * 搜索业务实现
 * @author 逄小帅
 *
 */
public class SearchServiceFactory {
	

	/*实体bean处理处理实例*/
	private volatile static SearchServiceFactory INSTANCE = null;
	
	private ISearchUserService searchUserService;
	
	private ISearchMatchService searchMatchService;
	
	private ISearchVideoService searchVideoService;
	
	/**
	 * 获取实体bean处理实例
	 * @return SearchServiceFactory
	 */
	public static SearchServiceFactory getInstance(){
		
		if(INSTANCE == null){
			
			synchronized (SearchServiceFactory.class) {
				
				if(INSTANCE == null){
					
					INSTANCE = new SearchServiceFactory();
					
				}
				
			}
			
		}
		
		return INSTANCE;
		
	}

	public ISearchUserService getSearchUserService() {
		
		if(searchUserService == null){
			
			searchUserService = new SearchUserServiceImpl();
			
		}
		
		return searchUserService;
	}

	public ISearchMatchService getSearchMatchService() {
		
		if(searchMatchService == null){
			
			searchMatchService = new SearchMatchServiceImpl();
			
		}
		
		return searchMatchService;
	}

	public ISearchVideoService getSearchVideoService() {
		
		if(searchVideoService == null){
			
			searchVideoService = new SearchVideoServiceImpl();
			
		}
		
		return searchVideoService;
	}
	
	

}
