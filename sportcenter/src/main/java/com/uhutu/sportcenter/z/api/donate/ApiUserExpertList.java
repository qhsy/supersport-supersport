package com.uhutu.sportcenter.z.api.donate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.user.z.entity.UcUserinfoDonate;
import com.uhutu.dcom.user.z.entity.UcUserinfoExpert;
import com.uhutu.dcom.user.z.enums.SortEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.UserInfoExpert;
import com.uhutu.sportcenter.z.input.ApiUserExpertListInput;
import com.uhutu.sportcenter.z.result.ApiUserExpertListResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zooweb.user.UserCallFactory;

/**
 * 达人用户列表
 * @author pang_jhui
 *
 */
@Component
public class ApiUserExpertList extends RootApiBase<ApiUserExpertListInput, ApiUserExpertListResult> {
	
	@Autowired
	private UserServiceFactory serviceFactory;

	@Override
	protected ApiUserExpertListResult process(ApiUserExpertListInput input) {
		
		ApiUserExpertListResult userExpertResult = new ApiUserExpertListResult();
		
		QueryConditions conditions = new QueryConditions();
		
		conditions.setConditionEqual("status", SystemEnum.YES.getCode());
		
		Page<UcUserinfoExpert> expertPage = serviceFactory.getUserInfoExpertService().queryPageByConditon(1, 10, conditions);
		
		if(StringUtils.isNotBlank(input.getZoo().getToken())){
			
			UserCallFactory userCallFactory = new UserCallFactory();
			
			String userCode = userCallFactory.upUserCodeByAuthToken(input.getZoo().getToken(), DefineUser.Login_System_Default);
			
			UcUserinfoDonate donate = serviceFactory.getUserInfoDonateService().queryByUserCode(userCode);
			
			if(donate != null){
				
				userExpertResult.setFreePower(donate.getFreePower());
				
				userExpertResult.setFreePowerStr(String.format("%,d", donate.getFreePower()));
				
			}
			
		}
		
		if(expertPage != null){
			
			int i = 0;
			
			for(UcUserinfoExpert expert : expertPage.getContent()){
				
				i++;
				
				UserInfoExpert userInfoExpert = new UserInfoExpert();
				
				BeanUtils.copyProperties(expert, userInfoExpert);
				
				userInfoExpert.setSortPic(SortEnum.getByRank(i).getPicUrl());
				
				userInfoExpert.setPowerStr(String.format("%,d", userInfoExpert.getPower()));
				
				userExpertResult.getUserInfoExperts().add(userInfoExpert);
				
			}
			
		}
		
		return userExpertResult;
	}

}
