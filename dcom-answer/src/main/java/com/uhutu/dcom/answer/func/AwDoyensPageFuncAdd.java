package com.uhutu.dcom.answer.func;

import com.uhutu.dcom.answer.z.entity.AwPointRecommen;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class AwDoyensPageFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		MDataMap mDataMap = input.getDataMap();
		mDataMap.put("type", "dzsd4888100110030004");
		AwPointRecommen recommen = JdbcHelper.queryOne(AwPointRecommen.class, "type", "dzsd4888100110030004",
				"answer_code", input.getDataMap().get("answer_code"));
		if (recommen != null) {
			result.inError(88880003);
		} else {
			JdbcHelper.dataInsert(extendPageDefine.getPageSource().getTableName(), mDataMap);
		}
		return result;
	}
}
