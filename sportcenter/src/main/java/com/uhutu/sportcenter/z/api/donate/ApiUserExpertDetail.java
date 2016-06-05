package com.uhutu.sportcenter.z.api.donate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.entity.UcUserinfoExpert;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiUserExpertDetailInput;
import com.uhutu.sportcenter.z.result.ApiUserExpertDetailResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 达人用户详情信息
 * @author 逄小帅
 *
 */
@Component
public class ApiUserExpertDetail extends RootApiBase<ApiUserExpertDetailInput, ApiUserExpertDetailResult> {
	
	@Autowired
	private UserServiceFactory serviceFactory;

	@Override
	protected ApiUserExpertDetailResult process(ApiUserExpertDetailInput input) {
		
		ApiUserExpertDetailResult result = new ApiUserExpertDetailResult();
		
		Page<UcUserinfoExpert> expertPage = serviceFactory.getUserInfoExpertService().queryPageByConditon(1, 10, new QueryConditions());
		
		
		
		return result;
	}

}
