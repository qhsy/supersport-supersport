package com.uhutu.sportcenter.z.api.remark;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiPublishRemarkInput;
import com.uhutu.sportcenter.z.result.ApiPublishRemarkResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 评论发布
 * @author 逄小帅
 *
 */
@Component
public class ApiPublishRemark extends RootApiBase<ApiPublishRemarkInput, ApiPublishRemarkResult> {

	@Override
	protected ApiPublishRemarkResult process(ApiPublishRemarkInput input) {
		
		return new ApiPublishRemarkResult();
		
	}

}
