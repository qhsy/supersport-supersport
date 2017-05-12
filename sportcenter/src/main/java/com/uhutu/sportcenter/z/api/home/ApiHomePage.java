package com.uhutu.sportcenter.z.api.home;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.z.api.util.HomePageSupport;
import com.uhutu.sportcenter.z.input.ApiHomePageInput;
import com.uhutu.sportcenter.z.result.ApiHomePageResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 首页数据展示
 * 
 * @author xiegj
 */
@Service
public class ApiHomePage extends RootApiBase<ApiHomePageInput, ApiHomePageResult> {

	protected ApiHomePageResult process(ApiHomePageInput input) {
		ApiHomePageResult result = new ApiHomePageResult();
		result.setList(new HomePageSupport().getPageModels(input.getWidth(), input.getZoo().getToken()));
		return result;
	}
}
