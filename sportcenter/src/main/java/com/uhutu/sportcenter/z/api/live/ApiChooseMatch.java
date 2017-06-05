package com.uhutu.sportcenter.z.api.live;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnLiveInfo;
import com.uhutu.dcom.content.z.entity.CnLiveMatchInfo;
import com.uhutu.sportcenter.z.api.util.PositionSupport;
import com.uhutu.sportcenter.z.input.ApiChooseMatchInput;
import com.uhutu.sportcenter.z.result.ApiChooseMatchResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

import io.swagger.annotations.ApiModel;

/**
 * 选择比赛队伍接口
 * 
 * @author xiegj
 *
 */
@ApiModel
@Component
public class ApiChooseMatch extends RootApiToken<ApiChooseMatchInput, ApiChooseMatchResult> {

	@Override
	protected ApiChooseMatchResult process(ApiChooseMatchInput input) {

		ApiChooseMatchResult result = new ApiChooseMatchResult();
		if (StringUtils.isNotBlank(input.getCode())) {
			CnLiveInfo liveInfo = JdbcHelper.queryOne(CnLiveInfo.class, "code", input.getCode());
			CnLiveMatchInfo matchInfo = JdbcHelper.queryOne(CnLiveMatchInfo.class, "code", input.getGameCode());
			if (liveInfo != null && matchInfo != null) {
				PositionSupport.savePosition(input.getCode(), input.getGameCode(), input.getZoo().getToken(),
						input.getLongitude(), input.getLatitude());
			}
		}
		return result;
	}

}
