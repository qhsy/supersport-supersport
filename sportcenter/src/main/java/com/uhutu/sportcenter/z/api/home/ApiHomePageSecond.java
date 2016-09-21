package com.uhutu.sportcenter.z.api.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.api.util.HomePageSecondSupport;
import com.uhutu.sportcenter.z.input.ApiHomePageSecondInput;
import com.uhutu.sportcenter.z.result.ApiHomePageSecondResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 新首页
 * 
 * @author xiegj
 */
@Service
public class ApiHomePageSecond extends RootApiBase<ApiHomePageSecondInput, ApiHomePageSecondResult> {

	@Autowired
	private UserInfoSupport userInfoSupport;

	protected ApiHomePageSecondResult process(ApiHomePageSecondInput input) {
		ApiHomePageSecondResult result = new ApiHomePageSecondResult();

		result.getList().addAll(
				new HomePageSecondSupport(userInfoSupport).getPageModels(input.getWidth(), input.getZoo().getToken()));

		return result;
	}
}
