package com.uhutu.sportcenter.z.api.extend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.extend.z.entity.ReFieldType;
import com.uhutu.dcom.extend.z.entity.ReReportInfo;
import com.uhutu.sportcenter.z.entity.ReReportFieldForApi;
import com.uhutu.sportcenter.z.input.ApiReportFieldsInput;
import com.uhutu.sportcenter.z.result.ApiReportFieldsResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * Report报表详情接口
 * 
 * @author xiegj
 */
@Service
public class ApiReportFields extends RootApiBase<ApiReportFieldsInput, ApiReportFieldsResult> {

	protected ApiReportFieldsResult process(ApiReportFieldsInput input) {
		ApiReportFieldsResult result = new ApiReportFieldsResult();
		result.setFs(new ReReportInfo());
		ReReportFieldForApi fieldForApi = new ReReportFieldForApi();
		fieldForApi.setType(new ReFieldType());
		List<ReReportFieldForApi> li = new ArrayList<ReReportFieldForApi>();
		li.add(fieldForApi);
		result.setFields(li);
		return result;
	}

}
