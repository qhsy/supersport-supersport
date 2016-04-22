package com.uhutu.sportcenter.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.uhutu.dcom.component.page.QueryConditions;
import com.uhutu.dcom.content.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.enums.ContentEnum;
import com.uhutu.dcom.content.service.ContentBasicinfoServiceFactory;
import com.uhutu.sportcenter.api.entity.SportingMoment;
import com.uhutu.sportcenter.api.input.ApiSportingMomentsInput;
import com.uhutu.sportcenter.api.result.ApiSportingMomentsResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 *运动时刻
 * 
 * @author xiegj
 * 
 */
@Service
public class ApiSportingMoments extends RootApiBase<ApiSportingMomentsInput, ApiSportingMomentsResult> {

	@Autowired
	private ContentBasicinfoServiceFactory serviceFactory;
	
	protected ApiSportingMomentsResult process(ApiSportingMomentsInput input) {

		QueryConditions queryConditions = new QueryConditions();
		
		ApiSportingMomentsResult sportingMomentsResult = new ApiSportingMomentsResult();
		
		queryConditions.setConditionEqual("busiType", ContentEnum.sportmoment.getCode());
		
		Page<CnContentBasicinfo> page = serviceFactory.getContentBasicinfoService().queryPage(input.getPagination(), 10, queryConditions);
		
		List<CnContentBasicinfo> contentBasicInfos = page.getContent();
		
		List<SportingMoment> sports = new ArrayList<SportingMoment>();
		
		for(CnContentBasicinfo contentBasicInfo : contentBasicInfos){
			
			SportingMoment sportingMoment = new SportingMoment();
			
			BeanUtils.copyProperties(contentBasicInfo, sportingMoment);
			
			sports.add(sportingMoment);
			
		}
		
		sportingMomentsResult.setMoments(sports);
		
		return sportingMomentsResult;
	}

}
