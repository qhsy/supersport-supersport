package com.uhutu.dcom.content.func;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

/**
 * 赛事报名
 * @author 逄小帅
 *
 */
public class CnMatchSignFuncAdd extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {

		WebOperateResult operateResult = new WebOperateResult();

		MDataMap mInsertMap = new MDataMap();

		if (StringUtils.isNotBlank(extendPageDefine.getPageSource().getColumnNames())) {

			for (String sKey : StringUtils.split(extendPageDefine.getPageSource().getColumnNames(), ",")) {
				String sFieldData = sKey.trim();
				if (input.getDataMap().containsKey(sFieldData)) {
					mInsertMap.put(sFieldData, input.getDataMap().get(sFieldData));
				}
			}

		}

		mInsertMap.put("sign_code", input.getDataMap().get("sign_name"));

		JdbcHelper.dataInsert(extendPageDefine.getPageSource().getTableName(), mInsertMap);

		return operateResult;
	}

}
