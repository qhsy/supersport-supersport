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
import com.uhutu.dcom.user.entity.UcUserinfoExt;
import com.uhutu.dcom.user.service.UserServiceFactory;
import com.uhutu.sportcenter.api.entity.ContentBasicinfoForApi;
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
	
	@Autowired
	private UserServiceFactory userServiceFactory;
	
	protected ApiSportingMomentsResult process(ApiSportingMomentsInput input) {

		QueryConditions queryConditions = new QueryConditions();
		
		ApiSportingMomentsResult sportingMomentsResult = new ApiSportingMomentsResult();
		
		queryConditions.setConditionEqual("busiType", ContentEnum.sportmoment.getCode());
		
		Page<CnContentBasicinfo> page = serviceFactory.getContentBasicinfoService().queryPage(input.getPagination(), 10, queryConditions);
		
		List<CnContentBasicinfo> contentBasicInfos = page.getContent();
		
		List<ContentBasicinfoForApi> sports = new ArrayList<ContentBasicinfoForApi>();
		
		for(CnContentBasicinfo contentBasicInfo : contentBasicInfos){
			
			ContentBasicinfoForApi sportingMoment = new ContentBasicinfoForApi();		
			
			BeanUtils.copyProperties(contentBasicInfo, sportingMoment);
			
			UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(sportingMoment.getAuthor());
			
			sportingMoment.setAboutHead(ucUserinfoExt.getAboutHead());
			
			sportingMoment.setNickName(ucUserinfoExt.getNickName());
			
			sports.add(sportingMoment);
			
		}
		
		sportingMomentsResult.setMoments(sports);
		
		if(page.hasNext()){
			
			sportingMomentsResult.setNextPageFlag(true);
			
		}else{
			
			sportingMomentsResult.setNextPageFlag(false);
			
		}
		
		return sportingMomentsResult;
	}

}
