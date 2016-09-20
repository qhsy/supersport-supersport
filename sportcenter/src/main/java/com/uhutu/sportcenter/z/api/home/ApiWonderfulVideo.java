package com.uhutu.sportcenter.z.api.home;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiWonderfulVideoInput;
import com.uhutu.sportcenter.z.result.ApiWonderfulVideoResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 精彩视频
 * @author 逄小帅
 *
 */
@Component
public class ApiWonderfulVideo extends RootApiBase<ApiWonderfulVideoInput, ApiWonderfulVideoResult> {

	@Override
	protected ApiWonderfulVideoResult process(ApiWonderfulVideoInput input) {
		
		ApiWonderfulVideoResult videoResult = new ApiWonderfulVideoResult();
		
		return videoResult;
	}

}
