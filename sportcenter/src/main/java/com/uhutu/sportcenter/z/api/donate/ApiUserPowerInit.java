package com.uhutu.sportcenter.z.api.donate;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiUserPowerInitInput;
import com.uhutu.sportcenter.z.result.ApiUserPowerInitResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 用户能量初始化
 * @author 逄小帅
 *
 */
@Component
public class ApiUserPowerInit extends RootApiToken<ApiUserPowerInitInput, ApiUserPowerInitResult> {

	@Override
	protected ApiUserPowerInitResult process(ApiUserPowerInitInput input) {
		
		ApiUserPowerInitResult powerInitResult = new ApiUserPowerInitResult();
		
		return powerInitResult;
	}

}
