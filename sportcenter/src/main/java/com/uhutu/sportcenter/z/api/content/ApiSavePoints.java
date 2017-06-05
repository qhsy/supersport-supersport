package com.uhutu.sportcenter.z.api.content;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.z.api.util.PointSupport;
import com.uhutu.sportcenter.z.input.ApiSavePointsInput;
import com.uhutu.sportcenter.z.result.ApiSavePointsResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.model.MResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoocom.z.bean.TopUserFactory;

/**
 * 积分记录
 * 
 * @author xiegj
 */
@Service
public class ApiSavePoints extends RootApiToken<ApiSavePointsInput, ApiSavePointsResult> {

	protected ApiSavePointsResult process(ApiSavePointsInput input) {
		ApiSavePointsResult result = new ApiSavePointsResult();
		MResult rr = PointSupport.savePointFlow(input.getType(), input.getCode(), TopUserFactory.upUserCallFactory()
				.upUserCodeByAuthToken(input.getZoo().getToken(), DefineUser.Login_System_Default));
		if (!rr.upFlagTrue()) {
			result.inError(rr.getStatus());
		}
		return result;
	}

}
