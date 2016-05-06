package com.uhutu.dcom.content.z.service;

import java.util.List;

import com.uhutu.dcom.content.z.entity.CnAdvertiseDetail;

/**
 * 内容基本信息业务逻辑interface
 * 
 * @author xiegj
 *
 */

public interface IAdvertiseDetailService {

	/**
	 * 根据广告编号查询广告信息
	 * 
	 * @return 广告信息
	 */
	public List<CnAdvertiseDetail> queryByCode(String code);
}
