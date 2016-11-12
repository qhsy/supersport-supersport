package com.uhutu.dcom.user.z.page.func;

import com.uhutu.dcom.user.z.entity.UcSignCount;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class UcSignCountPageFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		int count = JdbcHelper.count(UcSignCount.class, "type=:type and za!=:za",
				MapHelper.initMap("type", input.getDataMap().get("type"), "za", input.getDataMap().get("za")));
		if (count > 0) {
			result.setStatus(0);
			result.setError("此类型限额已存在!");
		} else {
			UcSignCount countNum = new UcSignCount();
			countNum.setZa(input.getDataMap().get("za"));
			countNum.setType(input.getDataMap().get("type"));
			countNum.setCount(Integer.valueOf(input.getDataMap().get("count")));
			JdbcHelper.update(countNum, "type,count", "za");
		}
		return result;
	}

}
