package com.uhutu.sportcenter.z.api.remark;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiRemarkListInput;
import com.uhutu.sportcenter.z.result.ApiRemarkListResult;
import com.uhutu.zoocom.root.RootApiBase;
/**
 * 评论信息列表
 * @author 逄小帅
 *
 */
@Component
public class ApiRemarkList extends RootApiBase<ApiRemarkListInput, ApiRemarkListResult> {

	@Override
	protected ApiRemarkListResult process(ApiRemarkListInput input) {
		
		return new ApiRemarkListResult();
		
	}

}
