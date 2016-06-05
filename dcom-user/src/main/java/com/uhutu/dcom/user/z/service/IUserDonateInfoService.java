package com.uhutu.dcom.user.z.service;

import org.springframework.data.domain.Page;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.entity.UcDonateInfo;

/**
 * 用户捐赠信息service
 * @author pang_jhui
 *
 */
public interface IUserDonateInfoService {
	
	/**
	 * 根据查询条件查询分页信息
	 * @param pageNum
	 * 		页码
	 * @param limit
	 * 		每页展示条数
	 * @param conditions
	 * 		查询条件
	 * @return 分页信息
	 */
	public Page<UcDonateInfo> queryPageByCondtions(int pageNum,int limit,QueryConditions conditions); 

}
