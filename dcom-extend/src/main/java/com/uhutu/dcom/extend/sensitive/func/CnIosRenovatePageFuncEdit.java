package com.uhutu.dcom.extend.sensitive.func;

import java.util.Date;
import java.util.List;

import com.uhutu.dcom.extend.sensitive.z.entity.CnIosRenovate;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnIosRenovatePageFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		input.getDataMap().put("version", input.getDataMap().get("version").toLowerCase());
		List<CnIosRenovate> renovates = JdbcHelper.queryForList(CnIosRenovate.class, "", "",
				"za!=za and version!=version", input.getDataMap());
		if (renovates != null && renovates.size() > 0) {
			result.inError(81090007);
		} else {
			CnIosRenovate up = new CnIosRenovate();
			up.setZa(input.getDataMap().get("za"));
			up.setVersion(input.getDataMap().get("version"));
			up.setUrl(input.getDataMap().get("url"));
			up.setRemark(input.getDataMap().get("remark"));
			up.setZu(new Date());
			JdbcHelper.update(up, "version,url,remark", "za");
		}
		return result;

	}

}
