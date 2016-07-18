package com.uhutu.dcom.answer.func;

import com.uhutu.dcom.answer.z.entity.AwPointRecommen;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class AwPowerPageFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		MDataMap mDataMap = input.getDataMap();
		mDataMap.put("type", "dzsd4888100110030006");
		AwPointRecommen recommen = JdbcHelper.queryOne(AwPointRecommen.class, "", "",
				"type=:type and answer_code=:answer_code and za!=:za", mDataMap);
		if (recommen != null) {
			result.inError(88880001);
		} else {
			JdbcHelper.dataUpdate(extendPageDefine.getPageSource().getTableName(), mDataMap, "answer_code,sort", "");
		}
		return result;
	}
}
