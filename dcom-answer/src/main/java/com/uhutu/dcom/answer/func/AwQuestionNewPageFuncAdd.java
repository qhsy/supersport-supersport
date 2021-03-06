package com.uhutu.dcom.answer.func;

import java.util.List;

import com.uhutu.dcom.answer.z.entity.AwPointRecommen;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class AwQuestionNewPageFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		MDataMap mDataMap = input.getDataMap();
		mDataMap.put("type", "dzsd4888100110030002");
		AwPointRecommen recommen = JdbcHelper.queryOne(AwPointRecommen.class, "type", "dzsd4888100110030002",
				"answer_code", input.getDataMap().get("answer_code"));
		List<AwPointRecommen> li = JdbcHelper.queryForList(AwPointRecommen.class, "", "", "type", mDataMap);
		if (recommen != null) {
			result.inError(88880001);
		} else if (li.size() > 20) {
			result.inError(88880002);
		} else {
			JdbcHelper.dataInsert(extendPageDefine.getPageSource().getTableName(), mDataMap);
		}
		return result;
	}
}
