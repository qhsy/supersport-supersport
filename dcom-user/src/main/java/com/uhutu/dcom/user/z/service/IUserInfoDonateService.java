package com.uhutu.dcom.user.z.service;

import com.uhutu.dcom.user.z.entity.UcUserinfoDonate;

/**
 * 达人支持者业务接口
 * @author 逄小帅
 *
 */
public interface IUserInfoDonateService {
	
	/**
	 * 根据用户编号查询捐赠信息
	 * @param userCode
	 * @return
	 */
	public UcUserinfoDonate queryByUserCode(String userCode);
	
	/**
	 * 保存用户捐赠信息
	 * @param userInfoDonate
	 */
	public void save(UcUserinfoDonate userInfoDonate);

}
