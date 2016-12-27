package com.uhutu.dcom.content.func;

import org.apache.commons.lang3.StringUtils;

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
import com.uhutu.zooweb.helper.WebHelper;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class AdvertiseDetailPageFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		MDataMap mInsertMap = new MDataMap();

		// 只有存在于预定义列中的值才进行操作
		if (StringUtils.isNotBlank(extendPageDefine.getPageSource().getColumnNames())) {

			for (String sKey : StringUtils.split(extendPageDefine.getPageSource().getColumnNames(), ",")) {
				String sFieldData = sKey.trim();
				if (input.getDataMap().containsKey(sFieldData)) {
					mInsertMap.put(sFieldData, input.getDataMap().get(sFieldData));
				}
			}

		}

		// 注意，这里面的方法可能会随时变更，请勿复制粘贴，直接调用方法才对
		if (!extendPageDefine.getFieldInc().isEmpty()) {

			for (String sKey : extendPageDefine.getFieldInc().keySet()) {

				MDataMap mIncMap = extendPageDefine.getFieldInc().get(sKey);

				// 如果是插入时的自动生成key
				if (mIncMap.containsKey(DefineWebInc.Insert_Code)) {

					WebPageField webPageField = webPageModel.getFields().stream()
							.filter(w -> w.getFieldId().equals(sKey)).findFirst().get();
					mInsertMap.put(webPageField.getFieldData(),
							WebHelper.upCode(mIncMap.get(DefineWebInc.Insert_Code)));
				}

				// 如果是插入时的自动生成key
				if (mIncMap.containsKey(DefineWebInc.Insert_Value)) {

					WebPageField webPageField = webPageModel.getFields().stream()
							.filter(w -> w.getFieldId().equals(sKey)).findFirst().get();
					String sValue = mIncMap.get(DefineWebInc.Insert_Value);

					MParamReplace mParamReplace = new MParamReplace();
					mParamReplace.setUserCode(upUserCode());

					mInsertMap.put(webPageField.getFieldData(), ReplaceHelper.replaceBySet(sValue, mParamReplace));

				}

			}

		}

		JdbcHelper.dataInsert(extendPageDefine.getPageSource().getTableName(), mInsertMap);
		if ("dzsd4107100110050003".equals(input.getDataMap().get("piclink_type"))||"dzsd4107100110150003".equals(input.getDataMap().get("piclink_type"))) {
			CnShareInfo shareInfo = new CnShareInfo();
			shareInfo.setCode(mInsertMap.get("code"));
			shareInfo.setStatus("0");
			JdbcHelper.insert(shareInfo);
		}
		return new WebOperateResult();
	}

}
