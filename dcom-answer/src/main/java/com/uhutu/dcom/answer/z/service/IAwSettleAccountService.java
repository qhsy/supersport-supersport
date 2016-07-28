package com.uhutu.dcom.answer.z.service;

import com.uhutu.dcom.answer.z.entity.AwSettleAccount;

/**
 * 结算账户业务实现
 * @author 逄小帅
 *
 */
public interface IAwSettleAccountService {
	
	/**
	 * 更新结算账户信息
	 * @param settleAccount
	 */
	public void save(AwSettleAccount settleAccount);
	
	/**
	 * 根据用户编号查询结算账户信息
	 * @param userCode
	 * 		用户编号
	 * @return 结算信息
	 */
	public AwSettleAccount queryByUserCode(String userCode);

}
