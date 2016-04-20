package com.uhutu.sportcenter.api;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.api.input.ApiPublishSportingMomentInput;
import com.uhutu.sportcenter.api.result.ApiPublishSportingMomentResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 发布运动时刻
 * 
 * @author xiegj
 *
 */
@Service
public class ApiPublishSportingMoment
		extends RootApiToken<ApiPublishSportingMomentInput, ApiPublishSportingMomentResult> {

	protected ApiPublishSportingMomentResult process(ApiPublishSportingMomentInput input) {
		
		return new ApiPublishSportingMomentResult();
	}

}
