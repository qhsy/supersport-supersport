package com.uhutu.sportcenter.api;

import com.uhutu.sportcenter.api.input.ApiUserRegInput;
import com.uhutu.sportcenter.api.result.ApiUserRegResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 用户注册接口api
 * @author pang_jhui
 *
 */
public class ApiUserRegister extends RootApiBase< ApiUserRegInput,ApiUserRegResult> {

	public ApiUserRegResult process(ApiUserRegInput inputParam) {
		
		return new ApiUserRegResult();
	}

	

}
