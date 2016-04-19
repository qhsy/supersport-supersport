package com.uhutu.sportcenter.api;

import com.uhutu.sportcenter.api.input.ApiSocialLoginInput;
import com.uhutu.sportcenter.api.result.ApiSocialLoginResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 社交类账户登录
 * @author pang_jhui
 *
 */
public class ApiSocialLogin extends RootApiBase< ApiSocialLoginInput,ApiSocialLoginResult> {

	public ApiSocialLoginResult process(ApiSocialLoginInput inputParam) {
		
		return new ApiSocialLoginResult();
	}

}
