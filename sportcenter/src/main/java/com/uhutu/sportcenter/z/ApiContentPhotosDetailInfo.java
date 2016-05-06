package com.uhutu.sportcenter.z;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.z.input.ApiContentPhotosInput;
import com.uhutu.sportcenter.z.result.ApiContentPhotosResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 图集详情接口
 * 
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
