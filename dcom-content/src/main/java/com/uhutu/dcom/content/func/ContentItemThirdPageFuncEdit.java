package com.uhutu.dcom.content.func;

import java.util.List;

import com.uhutu.dcom.content.z.entity.CnContentItem;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class ContentItemThirdPageFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		MDataMap insert = input.getDataMap();
		insert.put("type", "dzsd4107100110060008");
		if (insert.get("start_time").equals(insert.get("end_time"))
				|| DateHelper.parseDate(insert.get("start_time"))
						.after(DateHelper.parseDate(insert.get("end_time")))) {
			result.inError(810710004);
		}
		if ("dzsd4107100110060001".equals(insert.get("type"))) {
			MDataMap map = new MDataMap();
			map.put("startTime", insert.get("start_time"));
			map.put("endTime", insert.get("end_time"));
			map.put("za", insert.get("za"));
			List<CnContentItem> li = JdbcHelper.queryForList(CnContentItem.class, "", "",
					" za!=:za and type='dzsd4107100110060001' and ((endTime>=:startTime and endTime<=:endTime) or (startTime>=:startTime and startTime<=:endTime) or (startTime<=:startTime and endTime>=:endTime) or (startTime>=:startTime and endTime<=:endTime)) ",
					map);
			if (li != null && !li.isEmpty() && li.size() > 0) {
				result.inError(810710005);
			}
		}
		if (result.upFlagTrue()) {
			JdbcHelper.dataUpdate(extendPageDefine.getPageSource().getTableName(), insert, "", "za");
		}
		return result;
	}

}