package com.uhutu.dcom.content.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 内容基本信息数据facotry
 * 
 * @author xiegj
 *
 */
@Component
public class AdvertiseDetailDaoFacotry {

	@Autowired
	private IAdvertiseDetailDao advertiseDetailDao;

	/**
	 * 分类业务数据访问
	 * 
	 */
	public IAdvertiseDetailDao getAdvertiseDetailDao() {
		return advertiseDetailDao;
	}

}
