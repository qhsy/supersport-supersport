package com.uhutu.sportcenter.z.api.user;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.z.input.ApiVersionInfoInput;
import com.uhutu.sportcenter.z.result.ApiVersionInfoResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 手机版本更新提示接口
 * 
 * @author xiegj @version1.0
 */
@Service
public class ApiVersionInfo extends RootApiBase<ApiVersionInfoInput, ApiVersionInfoResult> {

	protected ApiVersionInfoResult process(ApiVersionInfoInput inputParam) {
		ApiVersionInfoResult result = new ApiVersionInfoResult();

		return result;
	}

}