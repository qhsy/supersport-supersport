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

	@Query("select t from UcSocialLogin t where unionid=:unionid and type=:type")
	public UcSocialLogin queryByUnionId(@Param("type") String type,@Param("unionid") String unionid);
	
}
