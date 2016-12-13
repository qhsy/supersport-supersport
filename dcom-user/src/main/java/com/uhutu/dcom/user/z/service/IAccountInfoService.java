package com.uhutu.dcom.user.z.service;

import com.uhutu.dcom.user.z.entity.UcAccountInfo;

/**
 * 账户信息业务接口
 * @author 逄小帅
 *
 */
public interface IAccountInfoService {
	
	/**
	 * 根据用户编号查询账户信息
	 * @param userCode
	 * 		用户编号
	 * @return 账户信息
	 */
	public UcAccountInfo getAccountInfo(String userCode);

}
