package com.uhutu.sportcenter.z.api.home;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.entity.CnContentItem;
import com.uhutu.sportcenter.z.entity.HomePageModel;
import com.uhutu.sportcenter.z.input.ApiHomePageInput;
import com.uhutu.sportcenter.z.result.ApiHomePageResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 首页数据展示
 * 
 * @author xiegj
 */
@Service
public class ApiHomePage extends RootApiBase<ApiHomePageInput, ApiHomePageResult> {

	protected ApiHomePageResult process(ApiHomePageInput input) {
		ApiHomePageResult result = new ApiHomePageResult();
		result.setNextflag(nextDaydata(input.getPagination()));
		String str = getTime(input.getPagination());
		String t1 = str.contains("&") ? str.split("&")[0] : str.split("#")[0];
		String t2 = str.contains("&") ? str.split("&")[1] : str.split("#")[1];
		if (getTime(input.getPagination()).contains("#")) {
			HomePageModel dateShow = new HomePageModel();
			dateShow.setShowType("dzsd4699100110060004");
			dateShow.setDateShow(getTime(input.getPagination()).split("#")[0].substring(0, 11));
			result.getList().add(dateShow);
		}
		MDataMap mDataMap = new MDataMap();
		mDataMap.put("t1", t1);
		mDataMap.put("t2", t2);
		List<CnContentItem> items = JdbcHelper.queryForList(CnContentItem.class, "", "-sort,-",
				"startTime>:t1 and startTime<:t2 and end>=NOW()", mDataMap);
		for (int i = 0; i < items.size(); i++) {
			String itemType = items.get(i).getType();
			result.getList().addAll(getPageModels(itemType, t1, t2));
		}

		return result;
	}

	private String getTime(int num) {
		SimpleDateFormat df0 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (num <= 1) {
			return df0.format(new Date()) + "&" + df.format(new Date());
		} else {
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			start.add(Calendar.DAY_OF_MONTH, 1 - num);
			end.add(Calendar.DAY_OF_MONTH, 2 - num);
			return df0.format(start.getTime()) + "#" + df0.format(end.getTime());

		}
	}

	private boolean nextDaydata(int num) {
		boolean flag = false;
		if (num <= 1) {
			num = 2;
		} else {
			num = num + 1;
		}
		String str = getTime(num);
		String t1 = str.split("#")[0];
		String t2 = str.split("#")[1];
		MDataMap mDataMap = new MDataMap();
		mDataMap.put("t1", t1);
		mDataMap.put("t2", t2);
		List<CnContentItem> list = JdbcHelper.queryForList(CnContentItem.class, "", "",
				"startTime>:t1 and startTime<:t2 and end>=NOW()", mDataMap);
		if (list != null && !list.isEmpty() && list.size() > 0) {
			flag = true;
		}
		return flag;
	}

	private List<HomePageModel> getPageModels(String itemType, String t1, String t2) {
		List<HomePageModel> li = new ArrayList<HomePageModel>();
		switch (itemType) {
		case "dzsd4699100110060001":
			;
		case "dzsd4699100110060002":
			;
		case "dzsd4699100110060003":
			;
		}
		return li;
	}
}
