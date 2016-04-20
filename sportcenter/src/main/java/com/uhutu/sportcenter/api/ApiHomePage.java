package com.uhutu.sportcenter.api;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.api.input.ApiHomePageInput;
import com.uhutu.sportcenter.api.result.ApiHomePageResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 *首页 
 *@author Administrator
 * */
@Service
public class ApiHomePage extends RootApiBase<ApiHomePageInput, ApiHomePageResult> {

	protected ApiHomePageResult process(ApiHomePageInput input) {
		
		return new ApiHomePageResult();
	}

}
