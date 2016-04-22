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
import com.uhutu.sportcenter.api.entity.UserInfo;
import com.uhutu.sportcenter.api.input.ApiUserInfoInput;
import com.uhutu.sportcenter.api.result.ApiUserInfoResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 用户信息展示
 * @author pang_jhui
 *
 */
@Service
public class ApiUserInfo extends RootApiBase< ApiUserInfoInput,ApiUserInfoResult> {

	@Autowired
	private UserServiceFactory userServiceFactory;
	
	@Autowired
	private ContentBasicinfoServiceFactory serviceFactory;
	
	public ApiUserInfoResult process(ApiUserInfoInput inputParam ) {
		
		ApiUserInfoResult userInfoResult = new ApiUserInfoResult();
		
		if(inputParam.getPagination() <= 0){
			
			UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService()
					.queryByUserCode(inputParam.getUserCode());
			
			UserInfo apiUserInfo = new UserInfo();
			
			BeanUtils.copyProperties(ucUserinfoExt, apiUserInfo);
			
			userInfoResult.setUserInfo(apiUserInfo);
			
		}

		QueryConditions queryConditions = new QueryConditions();
		
		queryConditions.setConditionEqual("busiType", ContentEnum.sportmoment.getCode());
		
		queryConditions.setConditionEqual("author", inputParam.getUserCode());
		
		Page<CnContentBasicinfo> page = serviceFactory.getContentBasicinfoService().queryPage(inputParam.getPagination(), 10, queryConditions);
		
		List<CnContentBasicinfo> contentBasicInfos = page.getContent();
		
		List<ContentBasicinfoForApi> sports = new ArrayList<ContentBasicinfoForApi>();
		
		for(CnContentBasicinfo contentBasicInfo : contentBasicInfos){
			
			ContentBasicinfoForApi sportingMoment = new ContentBasicinfoForApi();
			
			BeanUtils.copyProperties(contentBasicInfo, sportingMoment);
			
			sports.add(sportingMoment);
			
		}
		
		userInfoResult.setMoments(sports);
		
		if(page.hasNext()){
			
			userInfoResult.setNextPageFlag(true);
			
		}else{
			
			userInfoResult.setNextPageFlag(false);
			
		}
	
		
		
		return userInfoResult;
	}

}
