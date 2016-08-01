package com.uhutu.dcom.user.z.page.func;

import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class UcAttentionInfoPageFuncDel extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		MDataMap map = new MDataMap();
		map.put("za", input.getDataMap().get("za"));
		map.put("status", "0");
		JdbcHelper.dataUpdate(extendPageDefine.getPageSource().getTableName(), map, "status", "za");
		return new WebOperateResult();
	}

	@Override
	public boolean upFlagCheck() {
		return false;
	}
}
