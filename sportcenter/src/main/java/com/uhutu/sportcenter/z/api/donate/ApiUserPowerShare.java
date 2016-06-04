package com.uhutu.sportcenter.z.api.donate;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiUserPowerShareInput;
import com.uhutu.sportcenter.z.result.ApiUserPowerShareResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 用户能量分享信息
 * @author pang_jhui
 *
 */
@Component
public class ApiUserPowerShare extends RootApiBase<ApiUserPowerShareInput, ApiUserPowerShareResult> {

	@Override
	protected ApiUserPowerShareResult process(ApiUserPowerShareInput input) {
		
		ApiUserPowerShareResult result = new ApiUserPowerShareResult();
		
		return result;
	}

	

}
