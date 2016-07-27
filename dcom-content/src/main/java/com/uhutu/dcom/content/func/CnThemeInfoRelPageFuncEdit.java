package com.uhutu.dcom.content.func;

import com.uhutu.dcom.content.z.entity.CnThemeInfoRel;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnThemeInfoRelPageFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		MDataMap map = new MDataMap();
		map.put("code", input.getDataMap().get("code"));
		map.put("column_code", input.getDataMap().get("column_code"));
		map.put("za", input.getDataMap().get("za"));
		CnThemeInfoRel rel = JdbcHelper.queryOne(CnThemeInfoRel.class, "", "",
				"code=:code and column_code=:column_code and za!=:za", map);
		if (rel != null) {
			result.setStatus(810710002);
			result.setError(TopHelper.upInfo(810710002));
		}
		if (result.upFlagTrue()) {
			CnThemeInfoRel detail = new CnThemeInfoRel();
			detail.setZa(input.getDataMap().get("za"));
			detail.setColumnCode(input.getDataMap().get("column_code"));
			detail.setSort(Integer.valueOf(input.getDataMap().get("sort")));
			JdbcHelper.update(detail, "column_code", "za");
		}
		return result;
	}
}
