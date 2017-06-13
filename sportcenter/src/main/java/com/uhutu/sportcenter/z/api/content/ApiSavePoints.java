package com.uhutu.sportcenter.z.api.content;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.support.SpecialEffectSupport;
import com.uhutu.dcom.remark.z.support.PointSupport;
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

	/**
	 * 积分类型
	 */
	private static final String JFType = "JFLXBH";

	protected ApiSavePointsResult process(ApiSavePointsInput input) {
		ApiSavePointsResult result = new ApiSavePointsResult();
		MResult rr = new MResult();
		if (JFType.equals(input.getCode())) {// 积分
			rr = PointSupport.savePointFlow(input.getType(), input.getCode(), TopUserFactory.upUserCallFactory()
					.upUserCodeByAuthToken(input.getZoo().getToken(), DefineUser.Login_System_Default));
		} else {// 特效
			SpecialEffectSupport.Instance().saveSpecialEffect(input.getType(), input.getCode());
		}
		if (!rr.upFlagTrue()) {
			result.inError(rr.getStatus());
		}
		return result;
	}

}
