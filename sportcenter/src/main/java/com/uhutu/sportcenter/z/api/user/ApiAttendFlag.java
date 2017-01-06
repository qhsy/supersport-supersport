package com.uhutu.sportcenter.z.api.user;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.content.z.entity.CnLiveVideoInfo;
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

		switch (input.getOperFlag()) {
		case "live":
			attendFlagResult.setAttendFlag(initLiveFlag(upUserCode(), input.getCode()));
			break;

		default:
			attendFlagResult.setAttendFlag(initFlag(upUserCode(), input.getCode()));
			break;
		}

		return attendFlagResult;
	}
	
	public boolean initFlag(String attention,String beAttention){
		
		boolean flag = false;
		
		UcAttentionInfo attentionInfo = JdbcHelper.queryOne(UcAttentionInfo.class, "attention", attention,
				"beAttention", beAttention, "status", SystemEnum.NORMAL.getCode());
		
		if(attentionInfo != null){
			
			flag = true;
			
		}
		
		return flag;
		
	}
	
	public boolean initLiveFlag(String attention,String roomId){
		
		boolean flag = false;
		
		CnLiveVideoInfo cnVideoInfo = JdbcHelper.queryOne(CnLiveVideoInfo.class, "code",roomId);
		
		if(cnVideoInfo != null && StringUtils.isNotEmpty(cnVideoInfo.getUserCode())){
			
			flag = initFlag(attention, cnVideoInfo.getUserCode());
			
		}
		
		return flag;
		
	}
	

}
