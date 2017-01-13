package com.uhutu.dcom.search.z.service.impl;

import com.aliyun.opensearch.CloudsearchSearch;
import com.uhutu.dcom.search.z.component.CloudSearchComponent;
import com.uhutu.dcom.search.z.config.CloudSearchConfig;
import com.uhutu.dcom.search.z.entity.ResponseData;
import com.uhutu.dcom.search.z.entity.ResponseError;
import com.uhutu.dcom.search.z.service.ISearchVideoService;
import com.uhutu.zoocom.helper.GsonHelper;

public class SearchVideoServiceImpl implements ISearchVideoService {

	@Override
	public ResponseData search(String title, int start, int number) {
		
		ResponseData responseData = new ResponseData();
		
		try {
			
			String queryStr = "content:'"+title+"'";
			
			CloudsearchSearch cloudSearch = CloudSearchComponent.getInstance().search(CloudSearchConfig.APP_NAME_CONTENT, queryStr);
			
			if(cloudSearch != null){
				
				cloudSearch.addSort("zc", "-");
				
				start = start < 0 ? 0 : start;
				
				cloudSearch.setStartHit(start);
				
				cloudSearch.setHits(number);
				
				String jsonStr = cloudSearch.search();
				
				responseData = GsonHelper.fromJson(jsonStr, responseData);
				
			}
			
		} catch (Exception e) {
			
			ResponseError responseError = new ResponseError();
			
			responseError.setCode("-1");
			
			responseData.setStatus("FAIL");
			
			responseError.setMessage(e.getMessage());
			
			responseData.getErrors().add(responseError);
			
		} 
		
		return responseData;
	}

}
