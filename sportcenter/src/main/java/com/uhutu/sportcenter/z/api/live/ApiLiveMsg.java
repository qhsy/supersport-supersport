package com.uhutu.sportcenter.z.api.live;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.properties.ConfigDcomContent;
import com.uhutu.dcom.content.z.properties.SettingsDcomContent;
import com.uhutu.sportcenter.z.input.ApiLiveMsgInput;
import com.uhutu.sportcenter.z.result.ApiLiveMsgResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

import io.swagger.annotations.ApiModel;

/**
 * 直播所需参数
 * 
 * @author xiegj
 *
 */
@ApiModel
@Component
public class ApiLiveMsg extends RootApiBase<ApiLiveMsgInput, ApiLiveMsgResult> {

	@Override
	protected ApiLiveMsgResult process(ApiLiveMsgInput input) {

		ApiLiveMsgResult result = new ApiLiveMsgResult();
		if (StringUtils.isNotBlank(input.getCode())) {
			CnLiveVideoDetail detail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "", "",
					"status='1' and code=:code ", MapHelper.initMap("code", input.getCode()));
			result.setSeconds((new Date().getTime() - detail.getZc().getTime()) / 1000);
			result.setWatch(detail.getWatch());
			result.setPraise(detail.getPraise());
			SettingsDcomContent dcomContent = ConfigDcomContent.upConfig();
			result.setWatchConstant(detail.getWatchConstant() == 0
					? Integer.valueOf(dcomContent.getLiveAppWatchConstant()) : detail.getWatchConstant());
			result.setPraiseConstant(detail.getPraiseConstant() == 0
					? Integer.valueOf(dcomContent.getLiveAppPraiseConstant()) : detail.getPraiseConstant());
		}
		return result;
	}

}
