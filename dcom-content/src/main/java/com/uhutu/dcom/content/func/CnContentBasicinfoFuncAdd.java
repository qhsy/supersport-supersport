package com.uhutu.dcom.content.func;

import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.helper.WebHelper;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnContentBasicinfoFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {

		String contentCode = WebHelper.upCode("CNB");
		MDataMap detailMap = new MDataMap();
		detailMap.put("code", contentCode);
		detailMap.put("content", input.getDataMap().get("content_detail"));
		JdbcHelper.dataInsert("cn_content_detail", detailMap);
		detailMap = input.getDataMap();
		detailMap.remove("content_detail");
		detailMap.put("code", contentCode);
		JdbcHelper.dataInsert("cn_content_basicinfo", detailMap);
		return new WebOperateResult();
	}

}
