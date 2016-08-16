package com.uhutu.sportcenter.z.api.content;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.entity.CnChickenSoup;
import com.uhutu.sportcenter.z.input.ApiSportChickenSoupInput;
import com.uhutu.sportcenter.z.result.ApiSportChickenSoupResult;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 运动小知识
 * 
 * @author xiegj
 */
@Service
public class ApiSportChickenSoup extends RootApiBase<ApiSportChickenSoupInput, ApiSportChickenSoupResult> {

	protected ApiSportChickenSoupResult process(ApiSportChickenSoupInput input) {
		ApiSportChickenSoupResult result = new ApiSportChickenSoupResult();
		CnChickenSoup soup = JdbcHelper.queryOne(CnChickenSoup.class, "status", "1");
		if (soup != null && StringUtils.isNotBlank(soup.getContent())) {
			result.setChickenSoup(soup.getContent());
		}
		return result;
	}

}
