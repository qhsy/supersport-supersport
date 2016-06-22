package com.uhutu.sportcenter.z.api.user;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.support.TecentSigSupport;
import com.uhutu.sportcenter.z.input.ApiForTecentSigInput;
import com.uhutu.sportcenter.z.result.ApiForTecentSigResult;
import com.uhutu.zoocom.root.RootApiToken;

/***
 * 获取腾讯独立登录模式sig信息
 * 
 * @author xiegj
 */
@Service
public class ApiForTecentSig extends RootApiToken<ApiForTecentSigInput, ApiForTecentSigResult> {

	public ApiForTecentSigResult process(ApiForTecentSigInput inputParam) {
		ApiForTecentSigResult result = new ApiForTecentSigResult();
		result.setSig(new TecentSigSupport().upSigCodeByUserCode(upUserCode()));
		return result;

	}
}
