package com.uhutu.sportcenter.z.api.user;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.sportcenter.z.input.ApiAttendFlagInput;
import com.uhutu.sportcenter.z.result.ApiAttendFlagResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

@Component
public class ApiAttendFlag extends RootApiToken<ApiAttendFlagInput, ApiAttendFlagResult> {

	@Override
	protected ApiAttendFlagResult process(ApiAttendFlagInput input) {

		ApiAttendFlagResult attendFlagResult = new ApiAttendFlagResult();

		UcAttentionInfo attentionInfo = JdbcHelper.queryOne(UcAttentionInfo.class, "attention", upUserCode(),
				"beAttention", input.getBeAttend(), "status", SystemEnum.NORMAL.getCode());
		
		if(attentionInfo != null){
			
			attendFlagResult.setAttendFlag(true);
			
		}

		return attendFlagResult;
	}

}
