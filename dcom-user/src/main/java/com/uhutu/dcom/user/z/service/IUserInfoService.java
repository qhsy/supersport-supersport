package com.uhutu.dcom.user.z.service;

import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.zooweb.user.UserReginsterResult;

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
	
	/**
	 * 根据用户编号查询用户信息
	 * @param code
	 * 		用户编号
	 * @return 用户信息
	 */
	public UcUserinfo queryByCode(String code);
	
	/**
	 * 根据登录名称查询用户信息
	 * @param loginName
	 * 		登录名称
	 * @param flag
	 * 		用户状态
	 * @return 用户信息
	 */
	public UcUserinfo queryByLoginName(String loginName, String flag);
	
	/**
	 * 授权用户注册
	 * @param loginName
	 * 		登录名称
	 * @param loginPass
	 * 		登录密码
	 * @return 用户授权信息
	 */
	public UserReginsterResult regAuthUser(String loginName, String loginPass);
	
	/**
	 * 关注官方帐号
	 * @param userCode
	 * 		关注用户编号
	 */
	public void attendOffice(String userCode);
	

}
