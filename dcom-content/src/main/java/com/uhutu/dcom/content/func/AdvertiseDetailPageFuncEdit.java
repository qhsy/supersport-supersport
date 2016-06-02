package com.uhutu.dcom.content.func;

import java.util.List;

import com.uhutu.dcom.content.z.entity.CnAdvertiseDetail;
import com.uhutu.dcom.content.z.entity.CnAdvertiseInfo;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class AdvertiseDetailPageFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		if (input.getDataMap().get("start_time").equals(input.getDataMap().get("end_time"))
				|| DateHelper.parseDate(input.getDataMap().get("start_time"))
						.after(DateHelper.parseDate(input.getDataMap().get("end_time")))) {
			result.inError(810710004);
			return result;
		}
		CnAdvertiseInfo info = JdbcHelper.queryOne(CnAdvertiseInfo.class, "code", input.getDataMap().get("code"));
		if ("dzsd4107100110040001".equals(info.getType())) {
			List<CnAdvertiseDetail> details = JdbcHelper.queryForList(CnAdvertiseDetail.class, "", "",
					"code=:code and za!=:za", input.getDataMap());
			if (details != null && !details.isEmpty() && details.size() > 0) {
				result.inError(810710007);
			}
		}
		if (result.upFlagTrue()) {
			JdbcHelper.dataUpdate(extendPageDefine.getPageSource().getTableName(), input.getDataMap(), "", "za");
		}
		return result;
	}

}
