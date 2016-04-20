package com.uhutu.sportcenter.api;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.api.input.ApiLoginOutInput;
import com.uhutu.sportcenter.api.result.ApiLoginOutResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 用户信息退出
 * @author pang_jhui
 *
 */
@Service
public class ApiLoginOut extends RootApiBase< ApiLoginOutInput,ApiLoginOutResult> {

	public ApiLoginOutResult process(ApiLoginOutInput inputParam ) {
		
		return new ApiLoginOutResult();
		
	}

}
