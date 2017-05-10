package com.uhutu.dcom.content.func;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentItem;
import com.uhutu.dcom.content.z.entity.CnContentItemRel;
import com.uhutu.zoocom.helper.DateHelper;
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
		if (input.getDataMap().get("start_time").equals(input.getDataMap().get("end_time"))
				|| DateHelper.parseDate(input.getDataMap().get("start_time"))
						.after(DateHelper.parseDate(input.getDataMap().get("end_time")))) {
			result.inError(810710004);
		}
		if (result.upFlagTrue()) {
			CnContentItem item = JdbcHelper.queryOne(CnContentItem.class, "code", input.getDataMap().get("item_code"));
			CnContentBasicinfo binfo = JdbcHelper.queryOne(CnContentBasicinfo.class, "code",
					input.getDataMap().get("content_code"));
			if (item != null && binfo != null) {
				// 根据栏目类型做校验
				result = check(item.getType(), input.getDataMap().get("item_code"),
						input.getDataMap().get("content_code"), input.getDataMap().get("start_time"),
						input.getDataMap().get("end_time"), input.getDataMap().get("za"));
				if (result.upFlagTrue()) {
					CnContentItemRel relInfo = new CnContentItemRel();
					relInfo.setContentCode(input.getDataMap().get("content_code"));
					relInfo.setItemCode(input.getDataMap().get("item_code"));
					relInfo.setItemType(item.getType());
					relInfo.setSort(Integer.valueOf(input.getDataMap().get("sort")));
					relInfo.setZa(input.getDataMap().get("za"));
					relInfo.setTitle(input.getDataMap().get("title"));
					relInfo.setCover(input.getDataMap().get("cover"));
					relInfo.setStartTime(input.getDataMap().get("start_time"));
					relInfo.setEndTime(input.getDataMap().get("end_time"));
					relInfo.setRemark(input.getDataMap().get("remark"));
					JdbcHelper.update(relInfo,
							"itemCode,contentCode,itemType,cover,sort,title,start_time,end_time,remark", "za");
				}

			} else if (item == null || binfo == null) {
				result.setStatus(810710001);
				result.setError(TopHelper.upInfo(810710001));
			}
		}
		return result;
	}

	private WebOperateResult check(String itemType, String itemCode, String contentCode, String startTime,
			String endTime, String za) {
		WebOperateResult result = new WebOperateResult();
		if (StringUtils.isNotBlank(itemType)) {// 同一栏目下，内容只可关联一次
			MDataMap relMap = new MDataMap();
			relMap.put("itemCode", itemCode);
			relMap.put("contentCode", contentCode);
			relMap.put("za", za);
			List<CnContentItemRel> rel = JdbcHelper.queryForList(CnContentItemRel.class, "", "",
					" itemCode=:itemCode and contentCode=:contentCode and za!=:za ", relMap);
			if (rel != null && rel.size() > 0) {
				result.inError(810710002);
			}
		}
		return result;
	}
}
