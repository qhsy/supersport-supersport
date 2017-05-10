package com.uhutu.dcom.content.func;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnContentBasiTypePageFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
//		MDataMap insert = input.getDataMap();
		WebOperateResult result = new WebOperateResult();
//		String[] ccs = insert.get("content_code").split(",");
//		String typeCode = insert.get("code");
//		for (int i = 0; i < ccs.length; i++) {
//			CnContentBasicinfo cb = JdbcHelper.queryOne(CnContentBasicinfo.class, "code", ccs[i]);
//
//			if (cb != null && ((cb.getType() != null && !cb.getType().contains(typeCode)) || cb.getType() == null)) {
//				List<String> list = new ArrayList<String>();
//				if (cb.getType() != null) {
//					List<String> li = Arrays.asList(cb.getType().split(","));
//					list = new ArrayList<String>();
//					for (int j = 0; j < li.size(); j++) {
//						list.add(li.get(j));
//					}
//				}
//				list.add(typeCode);
//				cb.setType(StringUtils.join(list.toArray(), ","));
//				JdbcHelper.update(cb, "type", "za");
//			}
//		}

		return result;
	}

}
