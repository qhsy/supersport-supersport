package com.uhutu.sportcenter.z.api.label;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiLabelRelListInput;
import com.uhutu.sportcenter.z.result.ApiLabelRelListResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 标签关联内容列表
 * @author 逄小帅
 *
 */
@Component
public class ApiLabelRelList extends RootApiBase<ApiLabelRelListInput, ApiLabelRelListResult> {

	@Override
	protected ApiLabelRelListResult process(ApiLabelRelListInput input) {
		
		ApiLabelRelListResult result = new ApiLabelRelListResult();
		
		return result;
	}

	
	
}
