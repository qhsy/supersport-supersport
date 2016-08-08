package com.uhutu.dcom.pay.z.service;

import com.uhutu.dcom.pay.z.entity.PaCoinInfo;

/**
 * 金币信息service
 * @author 逄小帅
 *
 */
public interface IPaCoinInfoService{
	
	/**
	 * 金币信息更新
	 * @param paCoinInfo
	 */
	public void save(PaCoinInfo paCoinInfo);
	
	/**
	 * 根据用户编号查询金币信息
	 * @param userCode
	 * 		用户编号
	 * @return 金币信息
	 */
	public PaCoinInfo queryByUserCode(String userCode);
	
}
