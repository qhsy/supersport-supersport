package com.uhutu.dcom.content.func;

import com.uhutu.dcom.content.z.entity.CnPrizesInfo;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.model.MParamReplace;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageField;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.helper.ReplaceHelper;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnPrizesInfoPageFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		CnPrizesInfo cpi = JdbcHelper.queryOne(CnPrizesInfo.class, "za", input.getDataMap().get("za"));
		if (cpi.getStatus() == 1) {
			result.inError(810710020);
		}
		if (result.upFlagTrue()) {
			if (!extendPageDefine.getFieldInc().isEmpty()) {

				for (String sKey : extendPageDefine.getFieldInc().keySet()) {

					MDataMap mIncMap = extendPageDefine.getFieldInc().get(sKey);

					if (mIncMap.containsKey(DefineWebInc.Update_Value)) {

						WebPageField webPageField = webPageModel.getFields().stream()
								.filter(w -> w.getFieldId().equals(sKey)).findFirst().get();
						String sValue = mIncMap.get(DefineWebInc.Update_Value);

						MParamReplace mParamReplace = new MParamReplace();
						mParamReplace.setUserCode(upUserCode());

						input.getDataMap().put(webPageField.getFieldData(),
								ReplaceHelper.replaceBySet(sValue, mParamReplace));

					}
				}
			}

			JdbcHelper.dataUpdate(extendPageDefine.getPageSource().getTableName(), input.getDataMap(), "", "za");
		}
		return result;
	}
}
