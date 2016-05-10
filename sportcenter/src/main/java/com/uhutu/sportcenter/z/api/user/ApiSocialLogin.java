package com.uhutu.sportcenter.z.api.user;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.z.input.ApiSocialLoginInput;
import com.uhutu.sportcenter.z.result.ApiSocialLoginResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 社交类账户登录
 * 
 * @author pang_jhui
 *
 */
@Service
public class ApiSocialLogin extends RootApiBase<ApiSocialLoginInput, ApiSocialLoginResult> {

	public ApiSocialLoginResult process(ApiSocialLoginInput inputParam) {

		return new ApiSocialLoginResult();
	}

}
