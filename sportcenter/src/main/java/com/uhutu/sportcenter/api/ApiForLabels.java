package com.uhutu.sportcenter.api;

import com.uhutu.sportcenter.api.input.ApiForLabelsInput;
import com.uhutu.sportcenter.api.result.ApiForLabelsResult;
import com.uhutu.zoocom.root.RootApiBase;
/**
 *运动标签 
 * 
 * @author xiegj
 */
public class ApiForLabels extends RootApiBase<ApiForLabelsInput, ApiForLabelsResult> {

	protected ApiForLabelsResult process(ApiForLabelsInput input) {
		
		return new ApiForLabelsResult();
	}

}
