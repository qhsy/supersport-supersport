package com.uhutu.sportcenter.z.api.content;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.entity.CnShareInfo;
import com.uhutu.sportcenter.z.input.ApiShareInfoInput;
import com.uhutu.sportcenter.z.result.ApiShareInfoResult;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 分享接口
 * 
 * @author xiegj
 */
@Service
public class ApiShareInfo extends RootApiBase<ApiShareInfoInput, ApiShareInfoResult> {

	protected ApiShareInfoResult process(ApiShareInfoInput input) {
		ApiShareInfoResult result = new ApiShareInfoResult();
		if (StringUtils.isNotBlank(input.getCode())) {
			CnShareInfo shareInfo = JdbcHelper.queryOne(CnShareInfo.class, "code", input.getCode(), "status", "1");
			if (shareInfo != null) {
				result.setAboutDesc(shareInfo.getAboutDesc());
				result.setCode(shareInfo.getCode());
				result.setCover(shareInfo.getCover());
				result.setTitle(shareInfo.getTitle());
				result.setUrl(shareInfo.getUrl());
			}
		}
		return result;
	}

}
