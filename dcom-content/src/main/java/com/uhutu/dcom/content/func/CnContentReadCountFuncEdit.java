package com.uhutu.dcom.content.func;

import com.uhutu.dcom.content.z.entity.CnContentReadCount;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnContentReadCountFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		CnContentReadCount read = JdbcHelper.queryOne(CnContentReadCount.class, "contentCode", input.getDataMap().get("contentCode"));
		if (read != null) {
			read.setCount(Integer.valueOf(input.getDataMap().get("count")));
			read.setRemark(input.getDataMap().get("remark"));
			JdbcHelper.update(read, "count,remark", "za");
		}
		return result;
	}

}
