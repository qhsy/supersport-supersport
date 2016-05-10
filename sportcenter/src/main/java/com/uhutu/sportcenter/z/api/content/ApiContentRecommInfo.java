package com.uhutu.sportcenter.z.api.content;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiContentRecommInput;
import com.uhutu.sportcenter.z.result.ApiContentRecommResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 内容推荐信息
 * @author 逄小帅
 *
 */
@Component
public class ApiContentRecommInfo extends RootApiBase<ApiContentRecommInput, ApiContentRecommResult> {

	@Override
	protected ApiContentRecommResult process(ApiContentRecommInput input) {
		
		return new ApiContentRecommResult();
		
	}

}
