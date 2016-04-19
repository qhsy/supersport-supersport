package com.uhutu.sportcenter.api;

import com.uhutu.sportcenter.api.input.ApiVersionInfoInput;
import com.uhutu.sportcenter.api.result.ApiVersionInfoResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 手机版本更新提示接口 
 * 
 * @author xiegj
 * @version1.0
 */
public class ApiVersionInfo extends
		RootApiBase<ApiVersionInfoInput,ApiVersionInfoResult> {

	protected ApiVersionInfoResult process(ApiVersionInfoInput inputParam) {
		ApiVersionInfoResult result = new ApiVersionInfoResult();
		
		
		return result;
	}


}