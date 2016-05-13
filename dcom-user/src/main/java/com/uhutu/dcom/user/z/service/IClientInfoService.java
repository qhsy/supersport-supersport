package com.uhutu.dcom.user.z.service;

import com.uhutu.dcom.user.z.entity.UcClientInfo;

/**
 * 用户终端信息处理
 * 
 * @author xiegj
 *
 */
public interface IClientInfoService {

	/**
	 * 信息保存
	 * 
	 * @param clientInfo
	 */
	public void save(UcClientInfo clientInfo);
}
