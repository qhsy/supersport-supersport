package com.uhutu.dcom.pay.z.service;

import com.uhutu.dcom.pay.z.entity.PaPayInfo;

/**
 * 支付信息业务接口
 * @author 逄小帅
 *
 */
public interface IPaPayInfoService{
	
	/**
	 * 支付信息保存
	 * @param paPayInfo
	 * 
	 * @return 处理结果
	 */
	public int save(PaPayInfo paPayInfo);
	
	/**
	 * 根据订单编号查询支付信息
	 * @param orderCode
	 * @return
	 */
	public PaPayInfo queryByOrderCode(String orderCode);
	
}
