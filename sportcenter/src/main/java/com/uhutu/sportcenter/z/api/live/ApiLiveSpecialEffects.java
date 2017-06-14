package com.uhutu.sportcenter.z.api.live;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.support.SpecialEffectSupport;
import com.uhutu.sportcenter.z.input.ApiLiveSpecialEffectsInput;
import com.uhutu.sportcenter.z.result.ApiLiveSpecialEffectsResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zooweb.user.UserCallFactory;

import io.swagger.annotations.ApiModel;

/**
 * 特效信息
 * 
 * @author xiegj
 *
 */
@ApiModel
@Component
public class ApiLiveSpecialEffects extends RootApiToken<ApiLiveSpecialEffectsInput, ApiLiveSpecialEffectsResult> {

	@Override
	protected ApiLiveSpecialEffectsResult process(ApiLiveSpecialEffectsInput input) {

		ApiLiveSpecialEffectsResult result = new ApiLiveSpecialEffectsResult();
		if (StringUtils.isNotBlank(input.getCode())) {
			result.setLse(SpecialEffectSupport.Instance().getSpecialEffects(input.getCode(), new UserCallFactory()
					.upUserCodeByAuthToken(input.getZoo().getToken(), DefineUser.Login_System_Default)));
		}

		return result;
	}

}
