package com.uhutu.dcom.content.func;

import com.uhutu.dcom.content.z.entity.CnThemeDetailRel;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnThemeRelPageFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		MDataMap map = new MDataMap();
		map.put("code", input.getDataMap().get("code"));
		map.put("content_code", input.getDataMap().get("content_code"));
		map.put("za", input.getDataMap().get("za"));
		CnThemeDetailRel rel = JdbcHelper.queryOne(CnThemeDetailRel.class, "", "",
				"code=:code and content_code=:content_code and za!=:za", map);
		if (rel != null) {
			result.setStatus(810710002);
			result.setError(TopHelper.upInfo(810710002));
		}
		if (result.upFlagTrue()) {
			rel = new CnThemeDetailRel();
			rel.setZa(input.getDataMap().get("za"));
			rel.setCode(input.getDataMap().get("code"));
			rel.setContentCode(input.getDataMap().get("content_code"));
			rel.setSort(Integer.valueOf(input.getDataMap().get("sort")));
			JdbcHelper.update(rel, "sort", "za");
		}
		return result;
	}
}
