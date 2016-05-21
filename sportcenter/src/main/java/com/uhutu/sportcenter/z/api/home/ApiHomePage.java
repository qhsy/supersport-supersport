package com.uhutu.sportcenter.z.api.home;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;
import com.uhutu.sportcenter.z.input.ApiHomePageInput;
import com.uhutu.sportcenter.z.result.ApiHomePageResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 首页数据展示
 * 
 * @author xiegj
 */
@Service
public class ApiHomePage extends RootApiBase<ApiHomePageInput, ApiHomePageResult> {

	protected ApiHomePageResult process(ApiHomePageInput input) {
		ApiHomePageResult result = new ApiHomePageResult();
		System.out.println(input.getPagination() + "##" + getTime(input.getPagination()));
		return result;
	}

	private String getTime(int num) {
		SimpleDateFormat df0 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (num <= 1) {
			return df0.format(new Date()) + df.format(new Date());
		} else {
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			start.add(Calendar.DAY_OF_MONTH, num - 1);
			end.add(Calendar.DAY_OF_MONTH, num - 2);
			return df0.format(start.getTime()) + df0.format(end.getTime());

		}
	}
}
