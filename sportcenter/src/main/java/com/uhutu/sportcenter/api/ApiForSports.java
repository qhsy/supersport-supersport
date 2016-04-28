package com.uhutu.sportcenter.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.entity.CnContentSport;
import com.uhutu.dcom.content.service.ContentSportServiceFactory;
import com.uhutu.dcom.content.service.IContentSportService;
import com.uhutu.sportcenter.api.entity.ContentSportForApi;
import com.uhutu.sportcenter.api.input.ApiForSportsInput;
import com.uhutu.sportcenter.api.result.ApiForSportsResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 各种运动名称及logo图片
 * 
 * @author xiegj
 */
@Service
public class ApiForSports extends RootApiToken<ApiForSportsInput, ApiForSportsResult> {

	@Autowired
	private ContentSportServiceFactory contentSportServiceFactory;

	protected ApiForSportsResult process(ApiForSportsInput input) {
		ApiForSportsResult result = new ApiForSportsResult();

		IContentSportService service = contentSportServiceFactory.getContentSportService();

		List<CnContentSport> contentSports = service.queryAll();

		List<ContentSportForApi> sports = new ArrayList<ContentSportForApi>();
		if (contentSports != null && !contentSports.isEmpty() && contentSports.size() > 0) {
			for (int i = 0; i < contentSports.size(); i++) {
				ContentSportForApi sportInfo = new ContentSportForApi();
				BeanUtils.copyProperties(contentSports.get(i), sportInfo);
				sports.add(sportInfo);
			}
		}
		result.setSports(sports);
		return result;
	}

}
