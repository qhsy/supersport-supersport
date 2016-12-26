package com.uhutu.sportcenter.z.api.match;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiMatchInfoListInput;
import com.uhutu.sportcenter.z.result.ApiMacthInfoListResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 赛事列表信息接口
 * @author 逄小帅
 *
 */
@Component
public class ApiMatchInfoList extends RootApiBase<ApiMatchInfoListInput, ApiMacthInfoListResult> {

	@Override
	protected ApiMacthInfoListResult process(ApiMatchInfoListInput input) {
		
		ApiMacthInfoListResult macthInfoListResult = new ApiMacthInfoListResult();
		
		return macthInfoListResult;
	}

}
