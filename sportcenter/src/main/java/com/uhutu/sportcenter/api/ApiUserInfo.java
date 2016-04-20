package com.uhutu.sportcenter.api;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.api.input.ApiUserInfoInput;
import com.uhutu.sportcenter.api.result.ApiUserInfoResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 用户信息展示
 * @author pang_jhui
 *
 */
@Service
public class ApiUserInfo extends RootApiBase< ApiUserInfoInput,ApiUserInfoResult> {

	public ApiUserInfoResult process(ApiUserInfoInput inputParam ) {
		
		return new ApiUserInfoResult();
	}

}
