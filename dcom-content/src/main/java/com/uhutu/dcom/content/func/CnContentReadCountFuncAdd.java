package com.uhutu.dcom.content.func;

import com.uhutu.dcom.content.z.entity.CnContentReadCount;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnContentReadCountFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		CnContentReadCount read = JdbcHelper.queryOne(CnContentReadCount.class, "code", input.getDataMap().get("code"));
		if (read != null) {
			result.inError(810710012);
		} else {
			read = new CnContentReadCount();
			read.setCode(input.getDataMap().get("code"));
			read.setCount(Integer.valueOf(input.getDataMap().get("count")));
			read.setRemark(input.getDataMap().get("remark"));
			JdbcHelper.insert(read);
		}
		return result;
	}

}
