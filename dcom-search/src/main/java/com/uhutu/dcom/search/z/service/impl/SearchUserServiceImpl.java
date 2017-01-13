package com.uhutu.dcom.search.z.service.impl;

import com.aliyun.opensearch.CloudsearchSearch;
import com.uhutu.dcom.search.z.component.CloudSearchComponent;
import com.uhutu.dcom.search.z.config.CloudSearchConfig;
import com.uhutu.dcom.search.z.entity.ResponseData;
import com.uhutu.dcom.search.z.entity.ResponseError;
import com.uhutu.dcom.search.z.service.ISearchUserService;
import com.uhutu.zoocom.helper.GsonHelper;

public class SearchUserServiceImpl implements ISearchUserService {

	@Override
	public ResponseData search(String nickName, int start, int number) {

		
		ResponseData responseData = new ResponseData();
		
		try {
			
			String queryStr = "nick_name:'"+nickName+"'";
			
			CloudsearchSearch cloudSearch = CloudSearchComponent.getInstance().search(CloudSearchConfig.APP_NAME_USER, queryStr);
			
			if(cloudSearch != null){
				
				cloudSearch.setStartHit(start);
				
				cloudSearch.setHits(number);
				
				String jsonStr = cloudSearch.search();
				
				responseData = GsonHelper.fromJson(jsonStr, responseData);
				
			}
			
		} catch (Exception e) {
			
			ResponseError responseError = new ResponseError();
			
			responseError.setCode("-1");
			
			responseError.setMessage(e.getMessage());
			
			responseData.getErrors().add(responseError);
			
		} 
		
		return responseData;
	
	}

}
