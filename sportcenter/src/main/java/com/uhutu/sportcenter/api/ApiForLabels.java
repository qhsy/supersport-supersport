package com.uhutu.sportcenter.api;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.api.input.ApiForLabelsInput;
import com.uhutu.sportcenter.api.result.ApiForLabelsResult;
import com.uhutu.zoocom.root.RootApiToken;
/**
 *运动标签 
 * 
 * @author xiegj
 */
@Service
public class ApiForLabels extends RootApiToken<ApiForLabelsInput, ApiForLabelsResult> {

	protected ApiForLabelsResult process(ApiForLabelsInput input) {
		
		return new ApiForLabelsResult();
	}

}
