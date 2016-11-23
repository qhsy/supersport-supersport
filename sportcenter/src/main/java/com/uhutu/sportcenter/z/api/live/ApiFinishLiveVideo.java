package com.uhutu.sportcenter.z.api.live;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.sportcenter.z.input.ApiFinishLiveVideoInput;
import com.uhutu.sportcenter.z.result.ApiFinishLiveVideoResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 结束直播
 * 
 * @author xiegj
 *
 */
@Component
public class ApiFinishLiveVideo extends RootApiToken<ApiFinishLiveVideoInput, ApiFinishLiveVideoResult> {

	@Override
	protected ApiFinishLiveVideoResult process(ApiFinishLiveVideoInput input) {

		ApiFinishLiveVideoResult result = new ApiFinishLiveVideoResult();
		CnLiveVideoDetail detail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "", "zc desc limit 0,1",
				"user_code=:user_code", MapHelper.initMap("user_code", upUserCode()));
		if (detail != null) {
			detail.setLength(input.getLength());
			detail.setWatch(input.getWatch());
			detail.setPraise(input.getPraise());
			JdbcHelper.update(detail, "length,watch,praise", "za");
		}
		return result;

	}

}
