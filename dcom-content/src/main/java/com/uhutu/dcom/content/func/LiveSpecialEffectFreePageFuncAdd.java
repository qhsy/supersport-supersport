package com.uhutu.dcom.content.func;

import java.util.List;

import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class LiveSpecialEffectFreePageFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		List<MDataMap> rels = JdbcHelper
				.dataQuery(
						extendPageDefine.getPageSource().getTableName(), "", "", "", MapHelper.initMap("se_code",
								input.getDataMap().get("se_code"), "zs_type", input.getDataMap().get("zs_type")),
						0, 0);
		if (rels != null && rels.size() > 0) {
			result.inError(810710002);
		} else {
			JdbcHelper.dataInsert(extendPageDefine.getPageSource().getTableName(), input.getDataMap());
		}
		return result;
	}

}
