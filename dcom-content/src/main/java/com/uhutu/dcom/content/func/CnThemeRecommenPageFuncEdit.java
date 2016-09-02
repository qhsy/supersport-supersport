package com.uhutu.dcom.content.func;

import com.uhutu.dcom.content.z.entity.CnThemeRecommen;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnThemeRecommenPageFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		MDataMap map = new MDataMap();
		map.put("code", input.getDataMap().get("code"));
		map.put("user_code", input.getDataMap().get("user_code"));
		map.put("za", input.getDataMap().get("za"));
		CnThemeRecommen rel = JdbcHelper.queryOne(CnThemeRecommen.class, "", "",
				"code=:code and user_code=:user_code and za!=:za", map);
		if (rel != null) {
			result.setStatus(810710002);
			result.setError(TopHelper.upInfo(810710002));
		}
		if (result.upFlagTrue()) {
			CnThemeRecommen detail = new CnThemeRecommen();
			detail.setZa(input.getDataMap().get("za"));
			detail.setUserCode(input.getDataMap().get("user_code"));
			detail.setSort(Integer.valueOf(input.getDataMap().get("sort")));
			JdbcHelper.update(detail, "user_code,sort", "za");
		}
		return result;
	}
}
