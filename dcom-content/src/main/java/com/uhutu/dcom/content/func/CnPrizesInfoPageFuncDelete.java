package com.uhutu.dcom.content.func;

import com.uhutu.dcom.content.z.entity.CnPrizesInfo;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnPrizesInfoPageFuncDelete extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		CnPrizesInfo cpi = JdbcHelper.queryOne(CnPrizesInfo.class, "za", input.getDataMap().get("za"));
		if (cpi.getStatus() == 1) {
			result.inError(810710020);
		}
		if (result.upFlagTrue()) {
			JdbcHelper.dataDeleteByZa(extendPageDefine.getPageSource().getTableName(), input.getDataMap().get("za"));
		}
		return result;
	}

	@Override
	public boolean upFlagCheck() {
		return false;
	}
}
