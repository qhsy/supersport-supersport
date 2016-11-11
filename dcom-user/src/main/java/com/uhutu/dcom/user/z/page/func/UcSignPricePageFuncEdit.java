package com.uhutu.dcom.user.z.page.func;

import java.math.BigDecimal;

import com.uhutu.dcom.user.z.entity.UcSignPrice;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class UcSignPricePageFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		int count = JdbcHelper.count(UcSignPrice.class, "type=:type and za!=:za",
				MapHelper.initMap("type", input.getDataMap().get("type"), "za", input.getDataMap().get("za")));
		if (count > 0) {
			result.setStatus(0);
			result.setError("此类型价格已存在!");
		} else {
			UcSignPrice price = new UcSignPrice();
			price.setZa(input.getDataMap().get("za"));
			price.setType(input.getDataMap().get("type"));
			price.setPrice(BigDecimal.valueOf(Double.valueOf(input.getDataMap().get("price"))));
			JdbcHelper.update(price, "type,price", "za");
		}
		return result;
	}

}
