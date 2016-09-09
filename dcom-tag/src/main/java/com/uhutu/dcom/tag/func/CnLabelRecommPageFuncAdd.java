package com.uhutu.dcom.tag.func;

import com.uhutu.dcom.tag.z.entity.CnLabelRecomm;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnLabelRecommPageFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		MDataMap mDataMap = input.getDataMap();
		mDataMap.put("type", "dzsd4124100110020001");
		CnLabelRecomm recommen = JdbcHelper.queryOne(CnLabelRecomm.class, "type", "dzsd4124100110020001",
				"tag_code", input.getDataMap().get("tag_code"));
		if (recommen != null) {
			result.inError(81140001);
		} else {
			JdbcHelper.dataInsert(extendPageDefine.getPageSource().getTableName(), mDataMap);
		}
		return result;
	}
}
