package com.uhutu.sportcenter.api;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.api.input.ApiForLoginInput;
import com.uhutu.sportcenter.api.result.ApiForLoginResult;
import com.uhutu.zoocom.root.RootApiBase;
/***
 * 登录
 * @author xiegj *
 */
@Service
public class ApiForLogin extends RootApiBase<ApiForLoginInput,ApiForLoginResult> {

	public ApiForLoginResult process(ApiForLoginInput inputParam) {
		ApiForLoginResult result=new ApiForLoginResult();
		return result;
	}
}
