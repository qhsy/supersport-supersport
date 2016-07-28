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

}
