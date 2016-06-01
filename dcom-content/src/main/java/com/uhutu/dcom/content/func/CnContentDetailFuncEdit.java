package com.uhutu.dcom.content.func;

import com.uhutu.zoocom.helper.RegexHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnContentDetailFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		input.getDataMap().put("content",
				RegexHelper.upRegexEmpty(input.getDataMap().get("content"), "\\sstyle=[\'\"][^\'\"]*[\'\"]"));
		JdbcHelper.dataUpdate(extendPageDefine.getPageSource().getTableName(), input.getDataMap(), "", "za");
		return result;
	}

}
