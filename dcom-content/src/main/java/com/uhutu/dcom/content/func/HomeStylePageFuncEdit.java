package com.uhutu.dcom.content.func;

import java.util.List;

import com.uhutu.dcom.content.z.entity.CnHomeStyle;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class HomeStylePageFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();

		MDataMap map = new MDataMap();
		map.put("columnCode", input.getDataMap().get("column_code"));
		map.put("za", input.getDataMap().get("za"));
		List<CnHomeStyle> li = JdbcHelper.queryForList(CnHomeStyle.class, "", "",
				" za!=:za and column_code=:columnCode ", map);
		if (li != null && !li.isEmpty() && li.size() > 0) {
			result.inError(810710017);
		}
		if (result.upFlagTrue()) {
			JdbcHelper.dataUpdate(extendPageDefine.getPageSource().getTableName(), input.getDataMap(), "", "za");
		}
		return result;
	}

}
