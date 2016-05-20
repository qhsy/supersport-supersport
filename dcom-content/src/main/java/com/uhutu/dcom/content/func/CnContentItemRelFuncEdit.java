package com.uhutu.dcom.content.func;

import java.util.List;

import com.uhutu.dcom.content.z.entity.CnAdvertiseInfo;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentItem;
import com.uhutu.dcom.content.z.entity.CnContentItemRel;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnContentItemRelFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		CnContentItem item = JdbcHelper.queryOne(CnContentItem.class, "code", input.getDataMap().get("item_code"));
		CnContentBasicinfo binfo = JdbcHelper.queryOne(CnContentBasicinfo.class, "code",
				input.getDataMap().get("content_code"));
		CnAdvertiseInfo ainfo = JdbcHelper.queryOne(CnAdvertiseInfo.class, "code",
				input.getDataMap().get("content_code"));
		if ((item != null && ainfo != null) || (item != null && binfo != null)) {
			MDataMap relMap = new MDataMap();
			relMap.put("item_code", input.getDataMap().get("item_code"));
			relMap.put("content_code", input.getDataMap().get("content_code"));
			relMap.put("za", input.getDataMap().get("za"));
			List<CnContentItemRel> rel = JdbcHelper.queryForList(CnContentItemRel.class, "", "",
					" itemCode=:item_code and contentCode=:content_code and za!=:za ", relMap);
			if (rel != null && rel.size() > 0) {
				result.setStatus(810710002);
				result.setError(TopHelper.upInfo(810710002));
			} else if (rel == null || rel.isEmpty() || rel.size() == 0) {
				CnContentItemRel relInfo = new CnContentItemRel();
				relInfo.setContentCode(input.getDataMap().get("content_code"));
				relInfo.setItemCode(input.getDataMap().get("item_code"));
				relInfo.setItemType(item.getType());
				relInfo.setSort(input.getDataMap().get("sort"));
				relInfo.setZa(input.getDataMap().get("za"));
				JdbcHelper.update(relInfo, "itemCode,contentCode,itemType,sort", "za");
			}

		} else if (item == null || binfo == null || ainfo == null) {
			result.setStatus(810710001);
			result.setError(TopHelper.upInfo(810710001));
		}
		return result;
	}

}
