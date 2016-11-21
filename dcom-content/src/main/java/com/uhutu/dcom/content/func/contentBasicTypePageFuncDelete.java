package com.uhutu.dcom.content.func;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class contentBasicTypePageFuncDelete extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		CnContentBasicinfo cb = JdbcHelper.queryOne(CnContentBasicinfo.class, "za", input.getDataMap().get("za"));

		if (StringUtils.isNotBlank(cb.getType()) && cb.getType().contains(input.getDataMap().get("type"))) {
			List<String> li = Arrays.asList(cb.getType().split(","));
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < li.size(); i++) {
				if (!li.get(i).equals(input.getDataMap().get("type"))) {
					list.add(li.get(i));
				}
			}
			cb.setType(StringUtils.join(list.toArray(), ","));
			JdbcHelper.update(cb, "type", "za");
		}
		return result;
	}

	@Override
	public boolean upFlagCheck() {
		return false;
	}
}
