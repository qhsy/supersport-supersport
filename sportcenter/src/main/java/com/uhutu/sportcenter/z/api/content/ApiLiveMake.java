package com.uhutu.sportcenter.z.api.content;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.remark.z.entity.CnContentMake;
import com.uhutu.sportcenter.z.input.ApiLiveMakeInput;
import com.uhutu.sportcenter.z.result.ApiLiveMakeResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoocom.z.bean.TopUserFactory;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;

/**
 * 赛事预约
 * 
 * @author xiegj
 */
@Service
public class ApiLiveMake extends RootApiToken<ApiLiveMakeInput, ApiLiveMakeResult> {

	protected ApiLiveMakeResult process(ApiLiveMakeInput input) {
		ApiLiveMakeResult result = new ApiLiveMakeResult();
		String userCode = TopUserFactory.upUserCallFactory().upUserCodeByAuthToken(input.getZoo().getToken(),
				DefineUser.Login_System_Default);
		CnContentMake make = JdbcHelper.queryOne(CnContentMake.class, "content_code", input.getContentCode(),
				"user_code", userCode);
		if (input.isMakeFlag()) {
			if (make != null && "0".equals(make.getStatus())) {
				make.setStatus("1");
				JdbcHelper.update(make, "status", "za");
			} else if (make == null) {
				make = new CnContentMake();
				make.setCode(WebHelper.upCode("YYBH"));
				make.setContentCode(input.getContentCode());
				make.setStatus("1");
				make.setUserCode(userCode);
				JdbcHelper.insert(make);
			}
		} else if (!input.isMakeFlag()) {
			if (make != null && "1".equals(make.getStatus())) {
				make.setStatus("0");
				JdbcHelper.update(make, "status", "za");
			}
		}
		return result;
	}

}
