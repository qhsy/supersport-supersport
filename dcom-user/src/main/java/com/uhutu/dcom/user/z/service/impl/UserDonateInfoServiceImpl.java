package com.uhutu.dcom.user.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.page.QueryConditionUtil;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcDonateInfo;
import com.uhutu.dcom.user.z.service.IUserDonateInfoService;

/**
 * 用户捐赠相关业务实现
 * @author pang_jhui
 *
 */
@Service
public class UserDonateInfoServiceImpl implements IUserDonateInfoService {

	@Autowired
	private UserDaoFacotry userDaoFactory;
	
	@Override
	public Page<UcDonateInfo> queryPageByCondtions(int pageNum, int limit, QueryConditions conditions) {
		
		if(pageNum >= 1){
			
			pageNum--;
			
		}
		
		Sort sort = new Sort(Direction.DESC,"totalPower");
		
		PageRequest page = new PageRequest(pageNum, limit,sort);
		
		Specification<UcDonateInfo> spec = QueryConditionUtil.buildSpecification(conditions);
		
		Page<UcDonateInfo> donateInfoPage = userDaoFactory.getUserDonateInfoDao().findAll(spec, page);
		
		return donateInfoPage;
		
	}

	@Override
	public UcDonateInfo queryByCode(String supportCode, String beSupportCode) {
		
		return userDaoFactory.getUserDonateInfoDao().queryByCode(supportCode, beSupportCode);
	}

	@Override
	public void save(UcDonateInfo donateInfo) {
		
		userDaoFactory.getUserDonateInfoDao().save(donateInfo);
		
	}

}
