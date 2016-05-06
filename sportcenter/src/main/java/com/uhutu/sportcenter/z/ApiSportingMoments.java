package com.uhutu.sportcenter.z;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentBasicinfoServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.input.ApiSportingMomentsInput;
import com.uhutu.sportcenter.z.result.ApiSportingMomentsResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 运动时刻
 * 
 * @author xiegj
 * 
 */
@Service
public class ApiSportingMoments extends RootApiBase<ApiSportingMomentsInput, ApiSportingMomentsResult> {

	@Autowired
	private ContentBasicinfoServiceFactory serviceFactory;

	@Autowired
	private UserServiceFactory userServiceFactory;

	protected ApiSportingMomentsResult process(ApiSportingMomentsInput input) {

		QueryConditions queryConditions = new QueryConditions();

		ApiSportingMomentsResult sportingMomentsResult = new ApiSportingMomentsResult();

		queryConditions.setConditionEqual("busiType", ContentEnum.sportmoment.getCode());

		Page<CnContentBasicinfo> page = serviceFactory.getContentBasicinfoService().queryPage(input.getPagination(), 10,
				queryConditions);

		List<CnContentBasicinfo> contentBasicInfos = page.getContent();

		List<ContentBasicinfoForApi> sports = new ArrayList<ContentBasicinfoForApi>();

		for (CnContentBasicinfo contentBasicInfo : contentBasicInfos) {

			ContentBasicinfoForApi sportingMoment = new ContentBasicinfoForApi();

			BeanUtils.copyProperties(contentBasicInfo, sportingMoment);

			UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService()
					.queryByUserCode(sportingMoment.getAuthor());

			sportingMoment.setAboutHead(ucUserinfoExt.getAboutHead());

			sportingMoment.setNickName(ucUserinfoExt.getNickName());

			sports.add(sportingMoment);

		}

		sportingMomentsResult.setMoments(sports);

		if (page.hasNext()) {

			sportingMomentsResult.setNextPageFlag(true);

		} else {

			sportingMomentsResult.setNextPageFlag(false);

		}

		return sportingMomentsResult;
	}

}
