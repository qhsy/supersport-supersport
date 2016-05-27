package com.uhutu.dcom.user.z.service;

import com.uhutu.dcom.user.z.entity.SpAppVersion;

/**
 * app版本信息
 * @author 逄小帅
 *
 */
public interface IAppVersionService {
	
	/**
	 * 按照更新时间排序获取第一条内容
	 * @return app版本信息
	 */
	public SpAppVersion queryOrderByZcDesc(String systemType);

}
