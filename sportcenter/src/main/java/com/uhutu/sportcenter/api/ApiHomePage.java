package com.uhutu.sportcenter.api;

import com.uhutu.sportcenter.api.input.ApiHomePageInput;
import com.uhutu.sportcenter.api.result.ApiHomePageResult;
import com.uhutu.zoocom.root.RootApiBase;
import io.swagger.annotations.ApiModel;
@ApiModel
/**
 *首页 
 *@author Administrator
 * */
public class ApiHomePage extends RootApiBase<ApiHomePageInput, ApiHomePageResult> {

	protected ApiHomePageResult process(ApiHomePageInput input) {
		
		return new ApiHomePageResult();
	}

}
