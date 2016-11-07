package com.uhutu.sportcenter.z.api.extend;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.extend.sensitive.z.entity.CnIosRenovate;
import com.uhutu.sportcenter.z.input.ApiIosRenovateInput;
import com.uhutu.sportcenter.z.result.ApiIosRenovateResult;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * IOS热修复接口
 * 
 * @author xiegj
 */
@Service
public class ApiIosRenovate extends RootApiBase<ApiIosRenovateInput, ApiIosRenovateResult> {

	protected ApiIosRenovateResult process(ApiIosRenovateInput input) {
		ApiIosRenovateResult result = new ApiIosRenovateResult();

		if (StringUtils.isNotBlank(input.getVersion())) {
			CnIosRenovate renovate = JdbcHelper.queryOne(CnIosRenovate.class, "version", input.getVersion());
			if (renovate != null) {
				result.setUrl(renovate.getUrl());
			}
		}
		return result;
	}

}
