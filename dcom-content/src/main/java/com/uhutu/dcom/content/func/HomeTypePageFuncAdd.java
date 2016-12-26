package com.uhutu.dcom.content.func;

import com.uhutu.dcom.content.z.entity.CnHomeType;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.helper.WebHelper;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class HomeTypePageFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		CnHomeType homeStyle = JdbcHelper.queryOne(CnHomeType.class, "columnCode",
				input.getDataMap().get("column_code"));
		if (homeStyle != null) {
			result.inError(810710017);
		}
		if (result.upFlagTrue()) {
			MDataMap insert = input.getDataMap();
			insert.put("code", WebHelper.upCode("SYBSBH"));
			JdbcHelper.dataInsert(extendPageDefine.getPageSource().getTableName(), input.getDataMap());
		}
		return result;
	}

}
