package com.uhutu.dcom.content.func;

import com.uhutu.dcom.content.z.entity.CnWonderfulVideo;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnWonderfulVideoPageFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		
		WebOperateResult result = new WebOperateResult();
		
		MDataMap mDataMap = input.getDataMap();
		
		CnWonderfulVideo video = JdbcHelper.queryOne(CnWonderfulVideo.class, "content_code",
				input.getDataMap().get("content_code"));

		if (video != null) {

			result.inError(810710015);

		} else {
			JdbcHelper.dataInsert(extendPageDefine.getPageSource().getTableName(), mDataMap);
		}
		return result;
	}
}
