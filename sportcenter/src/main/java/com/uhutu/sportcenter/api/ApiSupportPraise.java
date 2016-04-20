package com.uhutu.sportcenter.api;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.api.input.ApiSupportPraiseInput;
import com.uhutu.sportcenter.api.result.ApiSupportPraiseResult;
import com.uhutu.zoocom.root.RootApiToken;

/***
 * 赞与嘘嘘接口
 * 
 * @author xiegj
 *
 */
@Service
public class ApiSupportPraise extends RootApiToken<ApiSupportPraiseInput, ApiSupportPraiseResult> {

	
	protected ApiSupportPraiseResult process(ApiSupportPraiseInput input) {
		
		return new ApiSupportPraiseResult();
	}

}
