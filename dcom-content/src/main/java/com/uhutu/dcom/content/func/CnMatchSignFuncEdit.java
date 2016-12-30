package com.uhutu.dcom.content.func;

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

/**
 * 赛事报名
 * @author 逄小帅
 *
 */
public class CnMatchSignFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {

		WebOperateResult operateResult = new WebOperateResult();
		
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
		
		String signCode = input.getDataMap().get("sign_name");
		
		input.getDataMap().put("sign_code", signCode);

		JdbcHelper.dataUpdate(extendPageDefine.getPageSource().getTableName(), input.getDataMap(), "", "za");

		return operateResult;
	}

}
