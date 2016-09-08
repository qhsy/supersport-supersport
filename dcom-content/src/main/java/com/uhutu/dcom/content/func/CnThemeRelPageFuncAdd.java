package com.uhutu.dcom.content.func;

import com.uhutu.dcom.content.z.entity.CnThemeDetailRel;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnThemeRelPageFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		CnThemeDetailRel rel = JdbcHelper.queryOne(CnThemeDetailRel.class, "code", input.getDataMap().get("code"), "contentCode",
				input.getDataMap().get("content_code"));
		if (rel != null) {
			result.setStatus(810710002);
			result.setError(TopHelper.upInfo(810710002));
		}
		if (result.upFlagTrue()) {
			rel = new CnThemeDetailRel();
			rel.setCode(input.getDataMap().get("code"));
			rel.setContentCode(input.getDataMap().get("content_code"));
			rel.setThemeCover(input.getDataMap().get("theme_cover"));
			rel.setSort(Integer.valueOf(input.getDataMap().get("sort")));
			JdbcHelper.insert(rel);
		}
		return result;
	}
}
