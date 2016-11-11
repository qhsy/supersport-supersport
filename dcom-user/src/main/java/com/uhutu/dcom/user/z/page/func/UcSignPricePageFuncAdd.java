package com.uhutu.dcom.user.z.page.func;

import com.uhutu.dcom.user.z.entity.UcSignPrice;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class UcSignPricePageFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		int count = JdbcHelper.count(UcSignPrice.class, "type=:type",
				MapHelper.initMap("type", input.getDataMap().get("type")));
		if (count > 0) {
			result.setStatus(0);
			result.setError("此类型价格已存在!");
		} else {
			JdbcHelper.dataInsert(extendPageDefine.getPageSource().getTableName(), MapHelper.initMap("type",
					input.getDataMap().get("type"), "price", input.getDataMap().get("price")));
		}
		return result;
	}

}
