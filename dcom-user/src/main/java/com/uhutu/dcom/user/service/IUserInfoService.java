package com.uhutu.dcom.user.service;

import com.uhutu.dcom.user.entity.UcUserinfo;

/**
 * 用户业务信息处理
 * @author pang_jhui
 *
 */
public interface IUserInfoService {
	
	/**
	 * 用户信息保存
	 * @param ucUserinfo
	 */
	public void save(UcUserinfo ucUserinfo);
	
	/**
	 * 用户信息查询
	 * @param id
	 *   主键标识
	 * @return 用户信息
	 */
	public UcUserinfo query(String id);

}
