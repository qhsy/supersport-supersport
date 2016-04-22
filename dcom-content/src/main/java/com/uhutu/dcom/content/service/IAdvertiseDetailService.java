package com.uhutu.dcom.content.service;

import java.util.List;

import com.uhutu.dcom.content.entity.CnAdvertiseDetail;

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
