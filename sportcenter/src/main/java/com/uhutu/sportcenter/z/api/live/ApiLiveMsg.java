package com.uhutu.sportcenter.z.api.live;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.dcom.content.z.properties.ConfigDcomContent;
import com.uhutu.dcom.content.z.properties.SettingsDcomContent;
import com.uhutu.sportcenter.z.input.ApiLiveMsgInput;
import com.uhutu.sportcenter.z.result.ApiLiveMsgResult;
import com.uhutu.zoocom.model.MDataMap;
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

			MDataMap mWhereMap = new MDataMap();

			mWhereMap.put("chatCode", input.getCode());

			mWhereMap.put("status", "1");

			CnLiveVideoDetail detail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "", "", "", mWhereMap);
			if (detail == null) {

				if (mWhereMap.containsKey("status")) {

					mWhereMap.remove("status");

				}

				detail = JdbcHelper.queryOne(CnLiveVideoDetail.class, "", "zc desc ", "", mWhereMap);

			}
			if (detail != null) {

				result.setSeconds((new Date().getTime() - detail.getZc().getTime()) / 1000);
				result.setWatch(detail.getWatch());
				result.setPraise(detail.getPraise());
				SettingsDcomContent dcomContent = ConfigDcomContent.upConfig();
				result.setWatchConstant(detail.getWatchConstant() == 0
						? Integer.valueOf(dcomContent.getLiveAppWatchConstant()) : detail.getWatchConstant());
				result.setPraiseConstant(detail.getPraiseConstant() == 0
						? Integer.valueOf(dcomContent.getLiveAppPraiseConstant()) : detail.getPraiseConstant());
				result.setBusiCode(detail.getBusiCode());
			}
		}
		return result;
	}

}
