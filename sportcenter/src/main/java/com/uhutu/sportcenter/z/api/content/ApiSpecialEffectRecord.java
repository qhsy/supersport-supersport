package com.uhutu.sportcenter.z.api.content;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.support.SpecialEffectSupport;
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
		SpecialEffectSupport.Instance().useSpecialEffect(input.getCode(), input.getSeCode());
		return result;
	}

}
