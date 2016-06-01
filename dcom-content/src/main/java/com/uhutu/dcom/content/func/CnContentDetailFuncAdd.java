package com.uhutu.dcom.content.func;

import java.util.List;

import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.zoocom.helper.RegexHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnContentDetailFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		MDataMap map = new MDataMap();
		map.put("code", input.getDataMap().get("code"));
		List<CnContentDetail> li = JdbcHelper.queryForList(CnContentDetail.class, "", "", "code=:code", map);
		if (li != null && li.size() > 0) {
			result.inError(810710006);
		} else {
			input.getDataMap().put("content",
					RegexHelper.upRegexEmpty(input.getDataMap().get("content"), "\\sstyle=[\'\"][^\'\"]*[\'\"]"));
			JdbcHelper.dataInsert(extendPageDefine.getPageSource().getTableName(), input.getDataMap());
		}
		return result;
	}

}
