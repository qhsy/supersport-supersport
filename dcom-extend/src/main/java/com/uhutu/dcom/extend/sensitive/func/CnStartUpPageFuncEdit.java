package com.uhutu.dcom.extend.sensitive.func;

import java.util.Date;

import com.uhutu.dcom.extend.sensitive.z.entity.CnStartUp;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnStartUpPageFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		if (input.getDataMap().get("start_time").equals(input.getDataMap().get("end_time"))
				|| DateHelper.parseDate(input.getDataMap().get("start_time"))
						.after(DateHelper.parseDate(input.getDataMap().get("end_time")))) {
			result.inError(81090005);
		}
		if (result.upFlagTrue()) {
			CnStartUp up = new CnStartUp();
			up.setZa(input.getDataMap().get("za"));
			up.setCover(input.getDataMap().get("cover"));
			up.setEndTime(input.getDataMap().get("end_time"));
			up.setStartTime(input.getDataMap().get("start_time"));
			up.setJumpUrl(input.getDataMap().get("jump_url"));
			up.setShowStatus(input.getDataMap().get("show_status"));
			up.setStayTime(Integer.valueOf(input.getDataMap().get("stay_time")));
			up.setRemark(input.getDataMap().get("remark"));
			up.setZu(new Date());
			JdbcHelper.update(up, "cover,start_time,end_time,jump_url,show_status,stay_time,remark", "za");
		}
		return result;
	}

}
