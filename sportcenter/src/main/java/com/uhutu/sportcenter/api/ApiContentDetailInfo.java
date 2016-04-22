package com.uhutu.sportcenter.api;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.api.input.ApiContentDetailInput;
import com.uhutu.sportcenter.api.result.ApiContentDetailResult;
import com.uhutu.zoocom.root.RootApiBase;
/**
 * 内容详情信息
 * @author pang_jhui
 *
 */
@Service
public class ApiContentDetailInfo extends RootApiBase<ApiContentDetailInput, ApiContentDetailResult> {

	@Override
	protected ApiContentDetailResult process(ApiContentDetailInput input) {
		
		
		
		return new ApiContentDetailResult();
		
	}

	

}
