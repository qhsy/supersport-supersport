package com.uhutu.sportcenter.z.api.live2;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.support.LiveSupport;
import com.uhutu.sportcenter.z.input.ApiChangeCountInput;
import com.uhutu.sportcenter.z.result.ApiChangeCountResult;
import com.uhutu.zoocom.root.RootApiToken;

import io.swagger.annotations.ApiModel;

/**
 * 改变直播数量
 * @author 逄小帅
 *
 */
@ApiModel
@Component
public class ApiChangeCount extends RootApiToken<ApiChangeCountInput, ApiChangeCountResult> {

	@Override
	protected ApiChangeCountResult process(ApiChangeCountInput input) {
		
		ApiChangeCountResult result = new ApiChangeCountResult();
		
		LiveSupport.getInstance().operLiveCount(input.getType(),input.getOptype(), input.getUserCode(), "praise",input.getFileId());
		
		return result;
	}

}
