package com.uhutu.dcom.content.func;

import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageField;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.helper.WebHelper;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnContentBasicinfoFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {

		// 注意，这里面的方法可能会随时变更，请勿复制粘贴，直接调用方法才对
		if (!extendPageDefine.getFieldInc().isEmpty()) {

			for (String sKey : extendPageDefine.getFieldInc().keySet()) {

				MDataMap mIncMap = extendPageDefine.getFieldInc().get(sKey);

				// 如果是插入时的自动生成key
				if (mIncMap.containsKey(DefineWebInc.Insert_Code)) {

					WebPageField webPageField = webPageModel.getFields().stream()
							.filter(w -> w.getFieldId().equals(sKey)).findFirst().get();
					input.getDataMap().put(webPageField.getFieldData(),
							WebHelper.upCode(mIncMap.get(DefineWebInc.Insert_Code)));
				}

			}

		}
		MDataMap map = input.getDataMap();
		if ("dzsd4699100110010001".equals(input.getDataMap().get("status"))) {
			map.put("publish_time", DateHelper.upNow());
		}
		map.put("zz", "1");
		JdbcHelper.dataInsert(extendPageDefine.getPageSource().getTableName(), input.getDataMap());
		return new WebOperateResult();
	}

}
