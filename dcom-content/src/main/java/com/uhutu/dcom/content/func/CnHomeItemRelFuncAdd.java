package com.uhutu.dcom.content.func;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.content.z.entity.CnAdvertiseDetail;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnHomeItem;
import com.uhutu.dcom.content.z.entity.CnHomeItemRel;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnHomeItemRelFuncAdd extends RootFunc {

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
			// 取基本信息
			CnHomeItem item = JdbcHelper.queryOne(CnHomeItem.class, "code", input.getDataMap().get("item_code"));
			CnContentBasicinfo binfo = JdbcHelper.queryOne(CnContentBasicinfo.class, "code",
					input.getDataMap().get("content_code"));
			CnAdvertiseDetail ainfo = JdbcHelper.queryOne(CnAdvertiseDetail.class, "code",
					input.getDataMap().get("content_code"));
			if ((item != null && ainfo != null) || (item != null && binfo != null)) {
				// 根据栏目类型做校验
				result = check(item.getType(), input.getDataMap().get("item_code"),
						input.getDataMap().get("content_code"), input.getDataMap().get("start_time"),
						input.getDataMap().get("end_time"));
				if (result.upFlagTrue()) {
					CnHomeItemRel relInfo = new CnHomeItemRel();
					relInfo.setContentCode(input.getDataMap().get("content_code"));
					relInfo.setItemCode(input.getDataMap().get("item_code"));
					relInfo.setItemType(item.getType());
					relInfo.setCover(input.getDataMap().get("cover"));
					relInfo.setLabelName(input.getDataMap().get("label_name"));
					relInfo.setTitle(input.getDataMap().get("title"));
					relInfo.setAuthor(input.getDataMap().get("author"));
					relInfo.setSort(Integer.valueOf(input.getDataMap().get("sort")));
					relInfo.setStartTime(input.getDataMap().get("start_time"));
					relInfo.setEndTime(input.getDataMap().get("end_time"));
					relInfo.setRemark(input.getDataMap().get("remark"));
					JdbcHelper.insert(relInfo);
				}
			} else {
				result.setStatus(810710001);
				result.setError(TopHelper.upInfo(810710001));
			}
		}
		return result;
	}

	private WebOperateResult check(String itemType, String itemCode, String contentCode, String startTime,
			String endTime) {
		WebOperateResult result = new WebOperateResult();
		// 一个栏目下同一轮播图时间不可重叠
		if ("dzsd4107100110110001".equals(itemType)) {
			MDataMap map = new MDataMap();
			map.put("startTime", startTime);
			map.put("endTime", endTime);
			map.put("itemType", "dzsd4107100110110001");
			map.put("itemCode", itemCode);
			map.put("contentCode", contentCode);
			List<CnHomeItemRel> li = JdbcHelper.queryForList(CnHomeItemRel.class, "", "",
					" itemType=:itemType and itemCode=:itemCode and contentCode=:contentCode and ((endTime>=:startTime and endTime<=:endTime) or (startTime>=:startTime and startTime<=:endTime) or (startTime<=:startTime and endTime>=:endTime) or (startTime>=:startTime and endTime<=:endTime)) ",
					map);
			if (li != null && !li.isEmpty() && li.size() > 0) {
				result.inError(810710010);
			}

		} else if (StringUtils.isNotBlank(itemType)) {// 同一栏目下，内容只可关联一次
			MDataMap relMap = new MDataMap();
			relMap.put("itemCode", itemCode);
			relMap.put("contentCode", contentCode);
			List<CnHomeItemRel> rel = JdbcHelper.queryForList(CnHomeItemRel.class, "", "",
					" itemCode=:itemCode and contentCode=:contentCode ", relMap);
			if (rel != null && rel.size() > 0) {
				result.inError(810710002);
			}
		}
		return result;
	}
}
