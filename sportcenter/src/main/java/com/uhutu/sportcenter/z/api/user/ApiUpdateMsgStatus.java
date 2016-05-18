package com.uhutu.sportcenter.z.api.user;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiUpdateMsgStatusInput;
import com.uhutu.sportcenter.z.result.ApiUpdateMsgStatusResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 消息状态更新
 * @author 逄小帅
 *
 */
@Component
public class ApiUpdateMsgStatus extends RootApiToken<ApiUpdateMsgStatusInput, ApiUpdateMsgStatusResult> {
	
	@Override
	protected ApiUpdateMsgStatusResult process(ApiUpdateMsgStatusInput input) {
		
		ApiUpdateMsgStatusResult apiUpdateMsgStatusResult = new ApiUpdateMsgStatusResult();
		
		
		return apiUpdateMsgStatusResult;
		
	}

}
