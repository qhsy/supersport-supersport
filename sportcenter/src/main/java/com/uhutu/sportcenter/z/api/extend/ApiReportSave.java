package com.uhutu.sportcenter.z.api.extend;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.z.input.ApiReportSaveInput;
import com.uhutu.sportcenter.z.result.ApiReportSaveResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * Report报表信息保存
 * 
 * @author xiegj
 */
@Service
public class ApiReportSave extends RootApiBase<ApiReportSaveInput, ApiReportSaveResult> {

	protected ApiReportSaveResult process(ApiReportSaveInput input) {
		ApiReportSaveResult result = new ApiReportSaveResult();
		
		return result;
	}

}
