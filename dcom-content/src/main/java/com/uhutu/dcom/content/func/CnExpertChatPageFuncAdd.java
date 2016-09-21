package com.uhutu.dcom.content.func;

import com.uhutu.dcom.content.z.entity.CnExpertChat;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnExpertChatPageFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		
		WebOperateResult result = new WebOperateResult();
		
		MDataMap mDataMap = input.getDataMap();
		
		CnExpertChat expertCaht = JdbcHelper.queryOne(CnExpertChat.class, "content_code",
				input.getDataMap().get("content_code"));

		if (expertCaht != null) {

			result.inError(810710014);

		} else {
			JdbcHelper.dataInsert(extendPageDefine.getPageSource().getTableName(), mDataMap);
		}
		return result;
	}
}
