package com.uhutu.dcom.activity.func;

import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.helper.WebHelper;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class AcActivityAnswerInfoFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		if (input.getDataMap().get("start_time").equals(input.getDataMap().get("end_time"))
				|| DateHelper.parseDate(input.getDataMap().get("start_time"))
						.after(DateHelper.parseDate(input.getDataMap().get("end_time")))) {
			result.inError(810710004);
		}
		if (result.upFlagTrue()) {
			MDataMap dataMap = input.getDataMap();
			dataMap.put("code", WebHelper.upCode("ACBH"));
			JdbcHelper.dataInsert(extendPageDefine.getPageSource().getTableName(), dataMap);
		}
		return result;
	}
}
