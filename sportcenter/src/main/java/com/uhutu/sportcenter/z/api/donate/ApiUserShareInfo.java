package com.uhutu.sportcenter.z.api.donate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.user.z.entity.UcUserinfoExpert;
import com.uhutu.dcom.user.z.enums.SortEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.UserInfoExpert;
import com.uhutu.sportcenter.z.input.ApiUserShareInfoInput;
import com.uhutu.sportcenter.z.result.ApiUserExpertListResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 用户分享信息
 * @author 逄小帅
 *
 */
@Component
public class ApiUserShareInfo extends RootApiBase<ApiUserShareInfoInput, ApiUserExpertListResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiUserExpertListResult process(ApiUserShareInfoInput input) {
		
		ApiUserExpertListResult result = new ApiUserExpertListResult();
		
		result.setFreePowerStr("");
		
		result.setFreePower(0);
		
		UcUserinfoExpert ucUxpert = userServiceFactory.getUserInfoExpertService().queryByCode(input.getUserCode());
		
		if(ucUxpert != null){
			
			UserInfoExpert expertInfo = new UserInfoExpert();
			
			BeanUtils.copyProperties(ucUxpert, expertInfo);
			
			expertInfo.setPowerStr(String.format("%,d", expertInfo.getPower()));
			
			expertInfo.setSortPic(SortEnum.getByRank(ucUxpert.getSort()).getPicUrl());
			
			result.getUserInfoExperts().add(expertInfo);
			
		}else{
			
			result.inError(81100003);
			
		}		
		
		return result;
		
	}

}
