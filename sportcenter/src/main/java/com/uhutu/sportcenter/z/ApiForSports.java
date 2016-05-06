package com.uhutu.sportcenter.z;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.entity.SpSportCategory;
import com.uhutu.dcom.content.z.service.ISportCategoryService;
import com.uhutu.dcom.content.z.service.SportCategoryServiceFactory;
import com.uhutu.sportcenter.z.entity.SportCategoryForApi;
import com.uhutu.sportcenter.z.input.ApiForSportsInput;
import com.uhutu.sportcenter.z.result.ApiForSportsResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 各种运动名称及logo图片
 * 
 * @author xiegj
 */
@Service
public class ApiForSports extends RootApiToken<ApiForSportsInput, ApiForSportsResult> {

	@Autowired
	private SportCategoryServiceFactory sportCategoryServiceFactory;

	protected ApiForSportsResult process(ApiForSportsInput input) {
		ApiForSportsResult result = new ApiForSportsResult();

		ISportCategoryService service = sportCategoryServiceFactory.getSportCategoryService();

		List<SpSportCategory> contentSports = service.queryAll();

		List<SportCategoryForApi> sports = new ArrayList<SportCategoryForApi>();
		if (contentSports != null && !contentSports.isEmpty() && contentSports.size() > 0) {
			for (int i = 0; i < contentSports.size(); i++) {
				SportCategoryForApi sportInfo = new SportCategoryForApi();
				BeanUtils.copyProperties(contentSports.get(i), sportInfo);
				sports.add(sportInfo);
			}
		}
		result.setSports(sports);
		return result;
	}

}
