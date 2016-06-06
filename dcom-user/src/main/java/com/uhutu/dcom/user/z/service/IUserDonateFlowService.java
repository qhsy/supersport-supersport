package com.uhutu.dcom.user.z.service;

import com.uhutu.dcom.user.z.entity.UcDonateFlow;

/**
 * 用户捐赠流水
 * @author 逄小帅
 *
 */
public interface IUserDonateFlowService {
	
	/**
	 * 捐赠流水更新
	 * @param donateFlow
	 */
	public void save(UcDonateFlow donateFlow);

}
