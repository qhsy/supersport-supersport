package com.uhutu.sportcenter.z.api.answer;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.hole.ImageCfUtil;
import com.uhutu.dcom.user.z.entity.UcSignInfo;
import com.uhutu.sportcenter.z.input.ApiForWatchCardInput;
import com.uhutu.sportcenter.z.result.ApiForWatchCardResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 观赛证
 * 
 * @author xiegj
 */
@Service
public class ApiForWatchCard extends RootApiToken<ApiForWatchCardInput, ApiForWatchCardResult> {

	protected ApiForWatchCardResult process(ApiForWatchCardInput input) {
		
		synchronized (ApiForWatchCard.class) {
			
			ApiForWatchCardResult result = new ApiForWatchCardResult();
			UcSignInfo info = JdbcHelper.queryOne(UcSignInfo.class, "user_code", upUserCode(), "type",
					"dzsd4107100510020004");
			if (info != null) {
				result.setPic(info.getPicUrl());
			} else {
				int simpleNum = JdbcHelper.count(UcSignInfo.class, "", MapHelper.initMap("type", "dzsd4107100510020004"))
						+ 1;
				info = new UcSignInfo();
				info.setCode(new DecimalFormat("00000").format(simpleNum));
				info.setType("dzsd4107100510020004");
				info.setUserCode(upUserCode());
				info.setStatus("dzsd4112100110030001");
				info.setPicUrl(ImageCfUtil.makeImageWatch(info.getCode()).getFileUrl());
				JdbcHelper.insert(info);
				result.setPic(info.getPicUrl());
			}

			return result;
			
		}
		
	}

}
