package com.uhutu.sportcenter.z.api.home;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiHotTopicInput;
import com.uhutu.sportcenter.z.result.ApiHotTopicResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 热门话题
 * @author 逄小帅
 *
 */
@Component
public class ApiHotTopic extends RootApiBase<ApiHotTopicInput, ApiHotTopicResult> {

	@Override
	protected ApiHotTopicResult process(ApiHotTopicInput input) {
		
		ApiHotTopicResult topicResult = new ApiHotTopicResult();
		
		return topicResult;
	}

}
