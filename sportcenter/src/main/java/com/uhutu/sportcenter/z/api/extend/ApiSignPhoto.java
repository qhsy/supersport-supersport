package com.uhutu.sportcenter.z.api.extend;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.entity.UcSignInfo;
import com.uhutu.sportcenter.z.input.ApiSignPhotoInput;
import com.uhutu.sportcenter.z.result.ApiSignPhotoResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 报名证件
 * 
 * @author xiegj
 */
@Service
public class ApiSignPhoto extends RootApiToken<ApiSignPhotoInput, ApiSignPhotoResult> {

	protected ApiSignPhotoResult process(ApiSignPhotoInput input) {
		ApiSignPhotoResult result = new ApiSignPhotoResult();
		List<UcSignInfo> li = JdbcHelper.queryForList(UcSignInfo.class, "", "",
				" status=:status and userCode=:userCode ",
				MapHelper.initMap("userCode", upUserCode(), "status", "dzsd4112100110030002"));
		if (li != null && li.size() > 0) {
			for (int i = 0; i < li.size(); i++) {
				result.getLi().add(li.get(i).getPicUrl());// 已报名
			}
		}

		return result;
	}

}
