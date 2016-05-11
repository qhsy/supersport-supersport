package com.uhutu.sportcenter.z.api.remark;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiRemarkCountInput;
import com.uhutu.sportcenter.z.result.ApiRemarkCountResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 各种评论数量
 * @author 逄小帅
 *
 */
@Component
public class ApiRemarkCount extends RootApiBase<ApiRemarkCountInput, ApiRemarkCountResult> {

	@Override
	protected ApiRemarkCountResult process(ApiRemarkCountInput input) {
		
		return new ApiRemarkCountResult();
		
	}

}
