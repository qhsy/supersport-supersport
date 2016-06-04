package com.uhutu.sportcenter.z.api.donate;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiUserExpertListInput;
import com.uhutu.sportcenter.z.result.ApiUserExpertListResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 达人用户列表
 * @author pang_jhui
 *
 */
@Component
public class ApiUserExpertList extends RootApiBase<ApiUserExpertListInput, ApiUserExpertListResult> {

	@Override
	protected ApiUserExpertListResult process(ApiUserExpertListInput input) {
		
		ApiUserExpertListResult userExpertResult = new ApiUserExpertListResult();
		
		return userExpertResult;
	}

}
