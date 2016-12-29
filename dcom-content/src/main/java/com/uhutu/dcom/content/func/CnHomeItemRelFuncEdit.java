package com.uhutu.dcom.content.func;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.content.z.entity.CnAdvertiseDetail;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnHomeItem;
import com.uhutu.dcom.content.z.entity.CnHomeItemRel;
import com.uhutu.dcom.content.z.entity.CnMatchInfo;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.api.webpage.WebOperateInput;
import com.uhutu.zooweb.api.webpage.WebOperateResult;
import com.uhutu.zooweb.api.webpage.WebPageModel;
import com.uhutu.zooweb.model.ExtendPageDefine;
import com.uhutu.zooweb.root.RootFunc;

public class CnHomeItemRelFuncEdit extends RootFunc {

	@Override
	public WebOperateResult process(WebPageModel webPageModel, ExtendPageDefine extendPageDefine,
			WebOperateInput input) {
		WebOperateResult result = new WebOperateResult();
		if (input.getDataMap().get("start_time").equals(input.getDataMap().get("end_time"))
				|| DateHelper.parseDate(input.getDataMap().get("start_time"))
						.after(DateHelper.parseDate(input.getDataMap().get("end_time")))) {
			result.inError(810710004);
		}
		if ((StringUtils.isBlank(input.getDataMap().get("content_code"))
				&& StringUtils.isNotBlank(input.getDataMap().get("match_code")))
				|| (StringUtils.isBlank(input.getDataMap().get("match_code"))
						&& StringUtils.isNotBlank(input.getDataMap().get("content_code")))) {
			if (result.upFlagTrue()) {
				CnHomeItem item = JdbcHelper.queryOne(CnHomeItem.class, "", "",
						"code='" + input.getDataMap().get("item_code") + "'", null);
				CnContentBasicinfo binfo = JdbcHelper.queryOne(CnContentBasicinfo.class, "", "",
						"code='" + input.getDataMap().get("content_code") + "'", null);
				CnAdvertiseDetail ainfo = JdbcHelper.queryOne(CnAdvertiseDetail.class, "", "",
						"code='" + input.getDataMap().get("content_code") + "'", null);
				CnMatchInfo minfo = JdbcHelper.queryOne(CnMatchInfo.class, "", "",
						"code='" + input.getDataMap().get("match_code") + "'", null);
				if ((item != null && ainfo != null) || (item != null && binfo != null)
						|| (item != null && minfo != null)) {
					// 根据栏目类型做校验
					result = check(item.getType(), input.getDataMap().get("item_code"),
							input.getDataMap().get("content_code"), input.getDataMap().get("match_code"),
							input.getDataMap().get("start_time"), input.getDataMap().get("end_time"),
							input.getDataMap().get("za"));
					if (result.upFlagTrue()) {
						CnHomeItemRel relInfo = new CnHomeItemRel();
						relInfo.setContentCode(input.getDataMap().get("content_code"));
						relInfo.setMatchCode(input.getDataMap().get("match_code"));
						relInfo.setItemCode(input.getDataMap().get("item_code"));
						relInfo.setItemType(item.getType());
						relInfo.setCover(input.getDataMap().get("cover"));
						relInfo.setSort(Integer.valueOf(input.getDataMap().get("sort")));
						relInfo.setZa(input.getDataMap().get("za"));
						relInfo.setLabelName(input.getDataMap().get("label_name"));
						relInfo.setTitle(input.getDataMap().get("title"));
						relInfo.setAuthor(input.getDataMap().get("author"));
						relInfo.setStartTime(input.getDataMap().get("start_time"));
						relInfo.setEndTime(input.getDataMap().get("end_time"));
						relInfo.setRemark(input.getDataMap().get("remark"));
						JdbcHelper.update(relInfo,
								"itemCode,content_code,match_code,item_type,cover,sort,title,label_name,author,start_time,end_time,remark",
								"za");
					}

				} else if (item == null || binfo == null || ainfo == null || minfo == null) {
					result.setStatus(810710001);
					result.setError(TopHelper.upInfo(810710001));
				}
			}
		} else {
			result.setStatus(0);
			result.setError("赛事 or 内容 只能选一个！");
		}
		return result;
	}

	private WebOperateResult check(String itemType, String itemCode, String contentCode, String matchCode,
			String startTime, String endTime, String za) {
		WebOperateResult result = new WebOperateResult();
		// 一个栏目下同一轮播图时间不可重叠
		if ("dzsd4107100110110001".equals(itemType)) {
			MDataMap map = new MDataMap();
			map.put("startTime", startTime);
			map.put("endTime", endTime);
			map.put("itemType", "dzsd4107100110110001");
			map.put("itemCode", itemCode);
			map.put("contentCode", contentCode);
			map.put("za", za);
			List<CnHomeItemRel> li = JdbcHelper.queryForList(CnHomeItemRel.class, "", "",
					" itemType=:itemType and za!=:za  and itemCode=:itemCode and contentCode=:contentCode and ((endTime>=:startTime and endTime<=:endTime) or (startTime>=:startTime and startTime<=:endTime) or (startTime<=:startTime and endTime>=:endTime) or (startTime>=:startTime and endTime<=:endTime)) ",
					map);
			if (li != null && !li.isEmpty() && li.size() > 0) {
				result.inError(810710010);
			}

		} else if (StringUtils.isNotBlank(itemType)) {// 同一栏目下，内容只可关联一次
			MDataMap relMap = new MDataMap();
			relMap.put("itemCode", itemCode);
			relMap.put("za", za);
			String sql = (StringUtils.isNoneBlank(contentCode) ? "and contentCode='" + contentCode + "'" : "")
					+ (StringUtils.isNoneBlank(matchCode) ? "and matchCode='" + matchCode + "'" : "");
			List<CnHomeItemRel> rel = JdbcHelper.queryForList(CnHomeItemRel.class, "", "",
					" itemCode=:itemCode " + sql + " and za!=:za ", relMap);
			if (rel != null && rel.size() > 0) {
				result.inError(810710002);
			}
		}
		return result;
	}
}
