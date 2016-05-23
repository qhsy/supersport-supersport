package com.uhutu.dcom.content.func;

import com.uhutu.dcom.content.z.entity.CnContentRecomm;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnContentRecommFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();

		CnContentRecomm exit = JdbcHelper.queryOne(CnContentRecomm.class, "", "",
				"za!=:za and contentCode=:content_code", input.getDataMap());
		if (exit != null) {
			result.setStatus(810710003);
			result.setError(TopHelper.upInfo(810710003));
		} else {
			JdbcHelper.dataUpdate(extendPageDefine.getPageSource().getTableName(), input.getDataMap(), "", "za");
		}
		return result;
	}

}
