package com.uhutu.dcom.user.z.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.user.z.entity.UcSocialLogin;

/**
 * 用户社交登录信息
 * @author 逄小帅
 *
 */
public interface IUserSocialLoginDao extends CrudRepository<UcSocialLogin, String> {

	@Query("select t from UcSocialLogin t where openid=:openid and unionid=:unionid")
	public UcSocialLogin queryByUnionId(@Param("openid") String openid,@Param("unionid") String unionid);
	
}
