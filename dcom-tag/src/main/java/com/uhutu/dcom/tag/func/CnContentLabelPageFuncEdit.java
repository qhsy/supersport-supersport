package com.uhutu.dcom.tag.func;

import com.uhutu.dcom.tag.z.entity.CnContentLabel;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnContentLabelPageFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		MDataMap mDataMap = input.getDataMap();
		CnContentLabel contentLabel = JdbcHelper.queryOne(CnContentLabel.class, "", "",
				"label_type=:label_type and name=:name and za!=:za", mDataMap);
		if (contentLabel != null) {
			result.inError(81140002);
		} else {
			JdbcHelper.dataUpdate(extendPageDefine.getPageSource().getTableName(), mDataMap, "", "za");
		}
		return result;
	}
}
