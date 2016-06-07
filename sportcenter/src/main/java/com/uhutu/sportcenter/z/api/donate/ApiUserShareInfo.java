package com.uhutu.sportcenter.z.api.donate;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.user.z.entity.UcUserinfoExpert;
import com.uhutu.dcom.user.z.enums.SortEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.UserInfoExpertDetail;
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
			
			int i = 0;
			
			List<UcUserinfoExpert> expertList = new ArrayList<UcUserinfoExpert>();
			
			QueryConditions conditions = new QueryConditions();
			
			conditions.setConditionEqual("status", SystemEnum.YES.getCode());
			
			conditions.setConditionGreaterThan("power", 0);
			
			Sort powerSort = new Sort(Direction.DESC,"power");
			
			Page<UcUserinfoExpert> expertPage = userServiceFactory.getUserInfoExpertService().queryPageByConditon(1, 10, conditions,powerSort);
			
			Sort zeroSort = new Sort(Direction.DESC,"sort");
			
			QueryConditions zeroCondition = new QueryConditions();
			
			zeroCondition.setConditionEqual("status", SystemEnum.YES.getCode());
			
			zeroCondition.setConditionEqual("power", 0);
			
			Page<UcUserinfoExpert> expertPowerPage = userServiceFactory.getUserInfoExpertService().queryPageByConditon(1, 10, zeroCondition, zeroSort);
			
			expertList.addAll(expertPage.getContent());
			
			expertList.addAll(expertPowerPage.getContent());
			
			UserInfoExpertDetail expertInfo = new UserInfoExpertDetail();
			
			if(expertPage != null){
				
				for(UcUserinfoExpert expert : expertList){
					
					i++;
					
					if(StringUtils.equals(expert.getCode(), ucUxpert.getCode())){
						
						break;
						
					}
					
				}
				
			}
			
			BeanUtils.copyProperties(ucUxpert, expertInfo);
			
			expertInfo.setPowerStr(String.format("%,d", expertInfo.getPower()));
			
			expertInfo.setSort(i);
			
			expertInfo.setSortPic(SortEnum.getByRank(ucUxpert.getSort()).getPicUrl());
			
			result.getUserInfoExperts().add(expertInfo);
			
		}else{
			
			result.inError(81100003);
			
		}		
		
		return result;
		
	}

}
