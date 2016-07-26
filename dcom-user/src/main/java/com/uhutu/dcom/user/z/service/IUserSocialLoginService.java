package com.uhutu.dcom.user.z.service;

import com.uhutu.dcom.user.z.entity.UcSocialLogin;

/**
 * 用户社交登录信息
 * @author 逄小帅
 *
 */
public interface IUserSocialLoginService {
	
	/**
	 * 社交用户信息登录
	 * @param ucSocialLogin
	 */
	public void save(UcSocialLogin ucSocialLogin);
	
	/**
	 * 根据openid和unionid查询社交用户登录信息
	 * @param openid
	 * 		开放标识
	 * @param unionid
	 * 		联合标识
	 * @return 用户社交登录
	 */
	public UcSocialLogin queryByUnionId(String openid,String unionid);

}
