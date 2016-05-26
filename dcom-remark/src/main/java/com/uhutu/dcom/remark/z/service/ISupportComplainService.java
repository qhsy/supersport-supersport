package com.uhutu.dcom.remark.z.service;

import com.uhutu.dcom.remark.z.entity.CnSupportComplain;

/**
 * 投诉service
 * @author 逄小帅
 *
 */
public interface ISupportComplainService {
	
	/**
	 * 投诉举报保存
	 * @param cnSupportComplain
	 */
	public void save(CnSupportComplain cnSupportComplain);

}
