package com.uhutu.dcom.tag.func;

import com.uhutu.dcom.tag.z.entity.CnContentLabel;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnContentLabelPageFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		MDataMap mDataMap = input.getDataMap();
		CnContentLabel contentLabel = JdbcHelper.queryOne(CnContentLabel.class, "label_type", input.getDataMap().get("label_type"),
				"name", input.getDataMap().get("name"));
		if (contentLabel != null) {
			result.inError(81140002);
		} else {
			JdbcHelper.dataInsert(extendPageDefine.getPageSource().getTableName(), mDataMap);
		}
		return result;
	}
}
