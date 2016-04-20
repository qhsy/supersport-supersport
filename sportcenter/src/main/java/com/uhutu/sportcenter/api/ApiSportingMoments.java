package com.uhutu.sportcenter.api;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.api.input.ApiSportingMomentsInput;
import com.uhutu.sportcenter.api.result.ApiSportingMomentsResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 *运动时刻
 * 
 * @author xiegj
 * 
 */
@Service
public class ApiSportingMoments extends RootApiBase<ApiSportingMomentsInput, ApiSportingMomentsResult> {

	protected ApiSportingMomentsResult process(ApiSportingMomentsInput input) {

		
		
		return new ApiSportingMomentsResult();
	}

}
