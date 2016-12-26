package com.uhutu.sportcenter.z.api.match;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiMatchSignListInput;
import com.uhutu.sportcenter.z.result.ApiMatchSignListResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 赛事报名信息列表
 * @author 逄小帅
 *
 */
@Component
public class ApiMatchSignList extends RootApiBase<ApiMatchSignListInput, ApiMatchSignListResult> {

	@Override
	protected ApiMatchSignListResult process(ApiMatchSignListInput input) {
		
		ApiMatchSignListResult matchSignListResult = new ApiMatchSignListResult();
		
		return matchSignListResult;
	}

}
