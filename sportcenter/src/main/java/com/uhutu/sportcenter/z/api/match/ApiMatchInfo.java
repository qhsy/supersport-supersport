package com.uhutu.sportcenter.z.api.match;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiMatchInfoInput;
import com.uhutu.sportcenter.z.result.ApiMatchInfoResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 赛事详情
 * @author 逄小帅
 *
 */
@Component
public class ApiMatchInfo extends RootApiBase<ApiMatchInfoInput, ApiMatchInfoResult> {

	@Override
	protected ApiMatchInfoResult process(ApiMatchInfoInput input) {
		
		ApiMatchInfoResult matchInfoResult = new ApiMatchInfoResult();
		
		return matchInfoResult;
	}

}
