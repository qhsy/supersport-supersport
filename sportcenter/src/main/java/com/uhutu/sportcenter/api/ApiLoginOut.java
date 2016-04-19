package com.uhutu.sportcenter.api;

import com.uhutu.sportcenter.api.input.ApiLoginOutInput;
import com.uhutu.sportcenter.api.result.ApiLoginOutResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 用户信息退出
 * @author pang_jhui
 *
 */
public class ApiLoginOut extends RootApiBase< ApiLoginOutInput,ApiLoginOutResult> {

	public ApiLoginOutResult process(ApiLoginOutInput inputParam ) {
		
		return new ApiLoginOutResult();
		
	}

}
