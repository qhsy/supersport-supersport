package com.uhutu.dcom.user.z.service;

import com.uhutu.dcom.user.z.entity.UcAccountInfo;
import com.uhutu.dcom.user.z.entity.UcTradeFlow;

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
	
	/**
	 * 注册账户信息
	 * @param userCode
	 * 		用户信息
	 */
	public void regAccInfo(String userCode);
	
	/**
	 * 更新账户信息
	 * @param accInfo
	 * 		账户信息
	 */
	public void updateAccInfo(UcAccountInfo accInfo);
	
	/**
	 * 更新用户交易流水
	 * @param tradeFlow
	 */
	public void saveTradeFlow(UcTradeFlow tradeFlow);

}
