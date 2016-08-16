package com.uhutu.dcom.pay.z.service;

import java.util.List;

import com.uhutu.dcom.pay.z.entity.PaCoinFlow;
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
	
	/**
	 * 根据用户编号查询金币流水
	 * @param userCode
	 * 		用户编号
	 * @return 金币流水
	 */
	public List<PaCoinFlow> queryCoinFlows(String userCode,int start,int number);
	
	/**
	 * 根据用户编号查询金币流水数量
	 * @param userCode
	 * 		用户编号
	 * @return 金币流水数量
	 */
	public int queryCoinFlowCount(String userCode);
	
}
