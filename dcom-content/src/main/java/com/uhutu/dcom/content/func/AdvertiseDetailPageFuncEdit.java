package com.uhutu.dcom.content.func;

import com.uhutu.dcom.content.z.entity.CnAdvertiseDetail;
import com.uhutu.dcom.content.z.entity.CnShareInfo;
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

public class AdvertiseDetailPageFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
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

		CnAdvertiseDetail detail = JdbcHelper.queryOne(CnAdvertiseDetail.class, "za", input.getDataMap().get("za"));
		JdbcHelper.dataUpdate(extendPageDefine.getPageSource().getTableName(), input.getDataMap(), "", "za");
		CnShareInfo share = JdbcHelper.queryOne(CnShareInfo.class, "code", input.getDataMap().get("code"));
		if ((!"dzsd4107100110050003".equals(input.getDataMap().get("piclink_type"))
				&& "dzsd4107100110050003".equals(detail.getPiclinkType()))
				|| (!"dzsd4107100110050003".equals(input.getDataMap().get("piclink_type")) && share != null)) {
			MDataMap delMap = new MDataMap();
			delMap.put("code", input.getDataMap().get("code"));
			JdbcHelper.dataDelete("CnShareInfo", delMap);
		} else if (("dzsd4107100110050003".equals(input.getDataMap().get("piclink_type"))
				&& !"dzsd4107100110050003".equals(detail.getPiclinkType()))
				|| ("dzsd4107100110050003".equals(input.getDataMap().get("piclink_type"))
						&& "dzsd4107100110050003".equals(detail.getPiclinkType()) && share == null)) {
			CnShareInfo shareInfo = new CnShareInfo();
			shareInfo.setCode(input.getDataMap().get("code"));
			shareInfo.setStatus("0");
			JdbcHelper.insert(shareInfo);
		}else if ((!"dzsd4107100110150003".equals(input.getDataMap().get("piclink_type"))
				&& "dzsd4107100110150003".equals(detail.getPiclinkType()))
				|| (!"dzsd4107100110150003".equals(input.getDataMap().get("piclink_type")) && share != null)) {
			MDataMap delMap = new MDataMap();
			delMap.put("code", input.getDataMap().get("code"));
			JdbcHelper.dataDelete("CnShareInfo", delMap);
		} else if (("dzsd4107100110150003".equals(input.getDataMap().get("piclink_type"))
				&& !"dzsd4107100110150003".equals(detail.getPiclinkType()))
				|| ("dzsd4107100110150003".equals(input.getDataMap().get("piclink_type"))
						&& "dzsd4107100110150003".equals(detail.getPiclinkType()) && share == null)) {
			CnShareInfo shareInfo = new CnShareInfo();
			shareInfo.setCode(input.getDataMap().get("code"));
			shareInfo.setStatus("0");
			JdbcHelper.insert(shareInfo);
		}
		return result;
	}

}
