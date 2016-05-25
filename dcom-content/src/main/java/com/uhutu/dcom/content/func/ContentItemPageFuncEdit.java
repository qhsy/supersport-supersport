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

public class ContentItemPageFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();

		if (input.getDataMap().get("start_time").equals(input.getDataMap().get("end_time"))
				|| DateHelper.parseDate(input.getDataMap().get("start_time"))
						.after(DateHelper.parseDate(input.getDataMap().get("end_time")))) {
			result.inError(810710004);
		}
		if ("dzsd4699100110060001".equals(input.getDataMap().get("type"))) {
			MDataMap map = new MDataMap();
			map.put("startTime", input.getDataMap().get("start_time"));
			map.put("endTime", input.getDataMap().get("end_time"));
			map.put("za", input.getDataMap().get("za"));
			List<CnContentItem> li = JdbcHelper.queryForList(CnContentItem.class, "", "",
					" za!=:za type='dzsd4699100110060001' and ((endTime>:startTime and endTime<:endTime) or (startTime>:startTime and startTime<:endTime) or (startTime<:startTime and endTime>:endTime) or (startTime>:startTime and endTime<:endTime)) ",
					map);
			if (li != null && !li.isEmpty() && li.size() > 0) {
				result.inError(810710005);
			}
		}
		if (result.upFlagTrue()) {
			JdbcHelper.dataUpdate(extendPageDefine.getPageSource().getTableName(), input.getDataMap(), "", "za");
		}
		return result;
	}

}
