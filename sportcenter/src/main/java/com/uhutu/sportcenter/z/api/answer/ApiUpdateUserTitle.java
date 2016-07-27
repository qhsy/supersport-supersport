package com.uhutu.sportcenter.z.api.answer;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiUpdateUserTitleInput;
import com.uhutu.sportcenter.z.result.ApiUpdateUserTitleResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 更新用户title
 * @author 逄小帅
 *
 */
@Component
public class ApiUpdateUserTitle extends RootApiToken<ApiUpdateUserTitleInput, ApiUpdateUserTitleResult> {

	@Override
	protected ApiUpdateUserTitleResult process(ApiUpdateUserTitleInput input) {
		
		ApiUpdateUserTitleResult result = new ApiUpdateUserTitleResult();
		
		return result;
	}

}
