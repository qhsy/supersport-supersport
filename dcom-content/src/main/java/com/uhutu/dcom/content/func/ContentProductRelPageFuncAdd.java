package com.uhutu.dcom.content.func;

import com.uhutu.dcom.content.z.entity.CnContentProductRel;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class ContentProductRelPageFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		CnContentProductRel rel = JdbcHelper.queryOne(CnContentProductRel.class, "productCode",
				input.getDataMap().get("product_code"), "contentCode", input.getDataMap().get("content_code"));
		if (rel != null) {
			result.setStatus(810710018);
			result.setError(TopHelper.upInfo(810710018));
		}
		if (result.upFlagTrue()) {
			rel = new CnContentProductRel();
			rel.setContentCode(input.getDataMap().get("content_code"));
			rel.setProductCode(input.getDataMap().get("product_code"));
			rel.setSort(Integer.valueOf(input.getDataMap().get("sort")));
			JdbcHelper.insert(rel);
		}
		return result;
	}
}
