package com.uhutu.dcom.content.func;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class ContentPhotosFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		String[] pics = input.getDataMap().get("picture").split(",");
		for (int i = 0; i < pics.length; i++) {
			MDataMap detail = new MDataMap();
			detail.put("contentCode", input.getDataMap().get("content_code"));
			detail.put("picture", pics[i]);
			if (StringUtils.isNotBlank(input.getDataMap().get("content"))) {
				detail.put("content", input.getDataMap().get("content"));
			} else {
				detail.put("content", "");
			}
			detail.put("zz", "1");
			JdbcHelper.dataInsert(extendPageDefine.getPageSource().getTableName(), detail);
		}
		return new WebOperateResult();
	}

}
