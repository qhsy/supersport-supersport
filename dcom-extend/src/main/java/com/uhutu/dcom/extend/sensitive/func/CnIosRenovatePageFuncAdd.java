package com.uhutu.dcom.extend.sensitive.func;

import java.util.Date;

import com.uhutu.dcom.extend.sensitive.z.entity.CnIosRenovate;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.helper.WebHelper;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnIosRenovatePageFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();

		input.getDataMap().put("version", input.getDataMap().get("version").toLowerCase());
		CnIosRenovate renovate = JdbcHelper.queryOne(CnIosRenovate.class, "version", input.getDataMap().get("version"));
		if (renovate != null) {
			result.inError(81090007);
		} else {
			CnIosRenovate up = new CnIosRenovate();
			up.setCode(WebHelper.upCode("IOSBH"));
			up.setVersion(input.getDataMap().get("version"));
			up.setUrl(input.getDataMap().get("url"));
			up.setRemark(input.getDataMap().get("remark"));
			up.setZc(new Date());
			JdbcHelper.insert(up);
		}
		return result;
	}

}
