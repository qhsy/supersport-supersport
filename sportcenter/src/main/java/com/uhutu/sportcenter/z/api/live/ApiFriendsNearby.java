package com.uhutu.sportcenter.z.api.live;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnLivePositionInfo;
import com.uhutu.sportcenter.z.api.util.PositionSupport;
import com.uhutu.sportcenter.z.input.ApiFriendsNearbyInput;
import com.uhutu.sportcenter.z.result.ApiFriendsNearbyResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.user.UserCallFactory;

import io.swagger.annotations.ApiModel;

/**
 * 附近的人
 * 
 * @author xiegj
 *
 */
@ApiModel
@Component
public class ApiFriendsNearby extends RootApiToken<ApiFriendsNearbyInput, ApiFriendsNearbyResult> {

	@Override
	protected ApiFriendsNearbyResult process(ApiFriendsNearbyInput input) {

		ApiFriendsNearbyResult result = new ApiFriendsNearbyResult();
		if (StringUtils.isNotBlank(input.getCode())) {
			String userCode = new UserCallFactory().upUserCodeByAuthToken(input.getZoo().getToken(),
					DefineUser.Login_System_Default);
			CnLivePositionInfo info = JdbcHelper.queryOne(CnLivePositionInfo.class, "", "zc desc ", "",
					MapHelper.initMap("code", input.getCode(), "user_code", userCode));
			if (info != null && info.getLatitude() != 0 & info.getLongitude() != 0) {
				result.setFs(PositionSupport.getNearBy(input.getPagination(), input.getCode(), userCode,
						info.getLatitude(), info.getLongitude()));
				if (input.getPagination() == 1) {// 只在第一页数据返回统计的总人数
					result.setSameCampNum(
							PositionSupport.campNum(input.getCode(), info.getGameCode(), PositionSupport.TypeSame));
					result.setOtherCampNum(
							PositionSupport.campNum(input.getCode(), info.getGameCode(), PositionSupport.TypeSame));
					result.setNearbyNum(result.getSameCampNum() + result.getOtherCampNum());
				}
			}
			if (result.getFs() != null && !result.getFs().isEmpty()) {
				result.setNextPage(PositionSupport.nextPage(input.getPagination(), input.getCode(), userCode,
						info.getLatitude(), info.getLongitude()));
			}
		}
		return result;
	}

}
