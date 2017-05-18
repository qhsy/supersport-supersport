package com.uhutu.sportcenter.z.api.content;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.z.input.ApiSavePointsInput;
import com.uhutu.sportcenter.z.result.ApiSavePointsResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 积分记录
 * 
 * @author xiegj
 */
@Service
public class ApiSavePoints extends RootApiToken<ApiSavePointsInput, ApiSavePointsResult> {

	protected ApiSavePointsResult process(ApiSavePointsInput input) {
		ApiSavePointsResult result = new ApiSavePointsResult();

		return result;
	}

}
