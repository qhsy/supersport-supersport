package com.uhutu.sportcenter.api;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.api.input.ApiContentPhotosInput;
import com.uhutu.sportcenter.api.result.ApiContentPhotosResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 图集详情接口
 * @author pang_jhui
 *
 */
@Service
public class ApiContentPhotosDetailInfo extends RootApiBase<ApiContentPhotosInput, ApiContentPhotosResult> {

	@Override
	protected ApiContentPhotosResult process(ApiContentPhotosInput input) {
		
		return new ApiContentPhotosResult();
	}

}
