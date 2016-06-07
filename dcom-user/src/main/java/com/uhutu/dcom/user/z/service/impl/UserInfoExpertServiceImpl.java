package com.uhutu.dcom.user.z.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.page.QueryConditionUtil;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcUserinfoExpert;
import com.uhutu.dcom.user.z.service.IUserInfoExpertService;

@Service
public class UserInfoExpertServiceImpl implements IUserInfoExpertService {
	
	@Autowired
	private UserDaoFacotry userDaoFactory;

	@Override
	public Page<UcUserinfoExpert> queryPageByConditon(int pageNum, int limit, QueryConditions conditions,Sort sort) {
		
		if(pageNum >= 1){
			
			pageNum--;
			
		}
		
		PageRequest page = new PageRequest(pageNum, limit,sort);
		
		Specification<UcUserinfoExpert> spec = QueryConditionUtil.buildSpecification(conditions);
		
		Page<UcUserinfoExpert> userInfoExpertPage = userDaoFactory.getUserInfoExpertDao().findAll(spec, page);
		
		return userInfoExpertPage;
		
	}

	@Override
	public UcUserinfoExpert queryByCode(String userCode) {
		
		return userDaoFactory.getUserInfoExpertDao().queryByCode(userCode);
	}

	@Override
	public void save(UcUserinfoExpert userInfoExpert) {
	
		if(StringUtils.isNotBlank(userInfoExpert.getZa()) 
				&& userDaoFactory.getUserInfoExpertDao().exists(userInfoExpert.getZa())){
			
			userInfoExpert.setZu(new Date());
			
		}else{
			
			userInfoExpert.setZc(new Date());
			
		}
		
		userDaoFactory.getUserInfoExpertDao().save(userInfoExpert);
		
	}

}
