package com.uhutu.sportcenter.z.api.match;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiShareMatchInfoInput;
import com.uhutu.sportcenter.z.result.ApiShareMatchInfoResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 赛事详情
 * @author 逄小帅
 *
 */
@Component
public class ApiShareMatchInfo extends RootApiBase<ApiShareMatchInfoInput, ApiShareMatchInfoResult> {

	@Override
	protected ApiShareMatchInfoResult process(ApiShareMatchInfoInput input) {
		
		ApiShareMatchInfoResult shareMatchInfoResult = new ApiShareMatchInfoResult();
		
		return shareMatchInfoResult;
		
	}

	

}
