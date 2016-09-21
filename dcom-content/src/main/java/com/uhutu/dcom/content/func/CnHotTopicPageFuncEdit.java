package com.uhutu.dcom.content.func;

import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnHotTopicPageFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		
		WebOperateResult result = new WebOperateResult();
		
		MDataMap mDataMap = input.getDataMap();
		
		JdbcHelper.dataUpdate(extendPageDefine.getPageSource().getTableName(), mDataMap, "content_code,cover,title,about,sort", "");
	
		return result;
	}
}
