package com.uhutu.sportcenter.z.api.extend;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.extend.z.entity.ReReportJson;
import com.uhutu.sportcenter.z.input.ApiReportCheckInput;
import com.uhutu.sportcenter.z.result.ApiReportCheckResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * Report报表信息保存
 * 
 * @author xiegj
 */
@Service
public class ApiReportCheck extends RootApiToken<ApiReportCheckInput, ApiReportCheckResult> {

	protected ApiReportCheckResult process(ApiReportCheckInput input) {
		ApiReportCheckResult result = new ApiReportCheckResult();
		if (StringUtils.isNotBlank(input.getReportCode())) {
			ReReportJson json = JdbcHelper.queryOne(ReReportJson.class, "code", input.getReportCode(), "user_code",
					upUserCode(), "status", "1");
			if (json != null) {
				result.setFlag(true);
			}
		} else {
			result.setStatus(0);
			result.setError("编号不能为空");
		}
		return result;
	}

}
