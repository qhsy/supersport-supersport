package com.uhutu.dcom.content.func;

import com.uhutu.dcom.content.z.entity.CnThemeInfoRel;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnThemeInfoRelPageFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		CnThemeInfoRel rel = JdbcHelper.queryOne(CnThemeInfoRel.class, "code", input.getDataMap().get("code"),
				"columnCode", input.getDataMap().get("column_code"));
		if (rel != null) {
			result.setStatus(810710002);
			result.setError(TopHelper.upInfo(810710002));
		}
		if (result.upFlagTrue()) {
			rel = new CnThemeInfoRel();
			rel.setCode(input.getDataMap().get("code"));
			rel.setColumnCode(input.getDataMap().get("column_code"));
			rel.setSort(Integer.valueOf(input.getDataMap().get("sort")));
			JdbcHelper.insert(rel);
		}
		return result;
	}
}
