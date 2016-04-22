package com.uhutu.dcom.content.service;

import com.uhutu.dcom.content.entity.CnAdvertiseInfo;

/**
 * 内容基本信息业务逻辑interface
 * 
 * @author xiegj
 *
 */

public interface IAdvertiseInfoService {
	/**
	 * 查询已发布广告
	 * 
	 * @return 广告信息
	 */
	public CnAdvertiseInfo queryAll();

	/**
	 * 根据广告编号查询广告信息
	 * 
	 * @return 广告信息
	 */
	public CnAdvertiseInfo queryByCode(String code);
}
