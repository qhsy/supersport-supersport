package com.uhutu.dcom.content.func;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnContentBasicinfoFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {

		// 注意，这里面的方法可能会随时变更，请勿复制粘贴，直接调用方法才对

		CnContentBasicinfo info = JdbcHelper.queryOne(CnContentBasicinfo.class, "za", input.getDataMap().get("za"));

		MDataMap map = input.getDataMap();
		if ("dzsd4699100110010001".equals(input.getDataMap().get("status"))
				&& "dzsd4699100110010002".equals(info.getStatus())) {
			map.put("publish_time", DateHelper.upNow());
		}
		if ("dzsd4107100110030001".equals(info.getContentType()) && !info.getVideoUrl().equals(map.get("video_url"))) {
			map.put("duration", String.valueOf(0));
		}
		JdbcHelper.dataUpdate(extendPageDefine.getPageSource().getTableName(), map, "", "za");
		return new WebOperateResult();
	}

}
