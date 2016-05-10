package com.uhutu.sportcenter.z.api.content;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiComplainInfoInput;
import com.uhutu.sportcenter.z.result.ApiComplainInfoResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 投诉接口业务处理
 * @author 逄小帅
 *
 */
@Component
public class ApiComplainInfo extends RootApiBase<ApiComplainInfoInput, ApiComplainInfoResult> {

	@Override
	protected ApiComplainInfoResult process(ApiComplainInfoInput input) {
		
		return new ApiComplainInfoResult();
		
	}

}
