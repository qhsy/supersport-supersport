package com.uhutu.sportcenter.z.api.content;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.z.input.ApiSpecialEffectRecordInput;
import com.uhutu.sportcenter.z.result.ApiSpecialEffectRecordResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 特效使用记录
 * 
 * @author xiegj
 */
@Service
public class ApiSpecialEffectRecord extends RootApiToken<ApiSpecialEffectRecordInput, ApiSpecialEffectRecordResult> {

	protected ApiSpecialEffectRecordResult process(ApiSpecialEffectRecordInput input) {
		ApiSpecialEffectRecordResult result = new ApiSpecialEffectRecordResult();

		return result;
	}

}
