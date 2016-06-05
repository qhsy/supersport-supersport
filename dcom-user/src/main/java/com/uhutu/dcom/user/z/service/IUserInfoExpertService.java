package com.uhutu.dcom.user.z.service;

import org.springframework.data.domain.Page;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.entity.UcUserinfoExpert;

/**
 * 达人用户信息业务接口
 * @author 逄小帅
 *
 */
public interface IUserInfoExpertService {
	
	/**
	 * 根据查询条件
	 * @param pageNum
	 * 		当前页码
	 * @param limit
	 * 		每页展示数量
	 * @param conditions
	 * 		查询条件
	 * @return 分页信息
	 */
	public Page<UcUserinfoExpert> queryPageByConditon(int pageNum,int limit,QueryConditions conditions);
	
	/**
	 * 根据用户编号查询用户达人信息
	 * @param userCode
	 * 		用户编号
	 * @return 达人用户信息
	 */
	public UcUserinfoExpert queryByCode(String userCode);

}
