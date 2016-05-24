package com.uhutu.sportcenter.z.api.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.entity.CnContentItem;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.api.util.HomePageSupport;
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

	@Autowired
	private UserInfoSupport userInfoSupport;

	protected ApiHomePageResult process(ApiHomePageInput input) {
		ApiHomePageResult result = new ApiHomePageResult();
		result.setNextflag(new HomePageSupport(userInfoSupport).nextDaydata(input.getPagination()));
		String str = new HomePageSupport(userInfoSupport).getTime(input.getPagination());
		String t1 = str.contains("&") ? str.split("&")[0] : str.split("#")[0];
		String t2 = str.contains("&") ? str.split("&")[1] : str.split("#")[1];
		if (new HomePageSupport(userInfoSupport).getTime(input.getPagination()).contains("#")) {
			HomePageModel dateShow = new HomePageModel();
			dateShow.setShowType("dzsd4699100110060004");
			dateShow.setDateShow(
					new HomePageSupport(userInfoSupport).getTime(input.getPagination()).split("#")[0].substring(0, 10));
			result.getList().add(dateShow);
		}
		MDataMap mDataMap = new MDataMap();
		mDataMap.put("t1", t1);
		mDataMap.put("t2", t2);
		List<CnContentItem> items = JdbcHelper.queryForList(CnContentItem.class, "", "-sort,-start_time",
				"startTime>:t1 and startTime<:t2 and endTime>=NOW()", mDataMap);
		for (int i = 0; i < items.size(); i++) {
			String itemType = items.get(i).getType();
			result.getList().addAll(new HomePageSupport(userInfoSupport).getPageModels(itemType));
		}

		return result;
	}
}
