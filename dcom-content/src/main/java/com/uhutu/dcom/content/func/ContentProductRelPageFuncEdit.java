package com.uhutu.dcom.content.func;

import com.uhutu.dcom.content.z.entity.CnContentProductRel;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class ContentProductRelPageFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		MDataMap map = new MDataMap();
		map.put("product_code", input.getDataMap().get("product_code"));
		map.put("content_code", input.getDataMap().get("content_code"));
		map.put("za", input.getDataMap().get("za"));
		CnContentProductRel rel = JdbcHelper.queryOne(CnContentProductRel.class, "", "",
				"product_code=:product_code and content_code=:content_code and za!=:za", map);
		if (rel != null) {
			result.setStatus(810710018);
			result.setError(TopHelper.upInfo(810710018));
		}
		if (result.upFlagTrue()) {
			rel = new CnContentProductRel();
			rel.setZa(input.getDataMap().get("za"));
			rel.setProductCode(input.getDataMap().get("product_code"));
			rel.setContentCode(input.getDataMap().get("content_code"));
			rel.setSort(Integer.valueOf(input.getDataMap().get("sort")));
			JdbcHelper.update(rel, "sort,productCode,contentCode", "za");
		}
		return result;
	}
}
