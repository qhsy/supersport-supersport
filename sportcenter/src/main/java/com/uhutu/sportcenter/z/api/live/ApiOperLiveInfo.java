package com.uhutu.sportcenter.z.api.live;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.sportcenter.z.input.ApiOperLiveInfoInput;
import com.uhutu.sportcenter.z.result.ApiOperLiveInfoResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

@Component
public class ApiOperLiveInfo extends RootApiToken<ApiOperLiveInfoInput, ApiOperLiveInfoResult> {

	@Override
	protected ApiOperLiveInfoResult process(ApiOperLiveInfoInput input) {
		
		ApiOperLiveInfoResult result = new ApiOperLiveInfoResult();
		
		MDataMap dataMap = new MDataMap();
		
		dataMap.put("code", input.getRoomId());
		
		CnLiveVideoDetail cnLiveVideoDetail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "", "-zc", "",dataMap );
		
		if(cnLiveVideoDetail != null){
			
			cnLiveVideoDetail.setStreamId(input.getStreamId());
			
			JdbcHelper.update(cnLiveVideoDetail, "streamId", "za");
			
		}
		
		return result;
	}

}
