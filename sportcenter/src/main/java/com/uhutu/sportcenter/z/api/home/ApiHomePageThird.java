package com.uhutu.sportcenter.z.api.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.api.util.HomePageThirdSupport;
import com.uhutu.sportcenter.z.input.ApiHomePageThirdInput;
import com.uhutu.sportcenter.z.result.ApiHomePageThirdResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 新首页
 * 
 * @author xiegj
 */
@Service
public class ApiHomePageThird extends RootApiBase<ApiHomePageThirdInput, ApiHomePageThirdResult> {

	@Autowired
	private UserInfoSupport userInfoSupport;

	protected ApiHomePageThirdResult process(ApiHomePageThirdInput input) {
		ApiHomePageThirdResult result = new ApiHomePageThirdResult();

		result.getList().addAll(new HomePageThirdSupport(userInfoSupport)
				.getPageModels(Integer.valueOf(input.getWidth()), input.getZoo().getToken()));

		return result;
	}
}
