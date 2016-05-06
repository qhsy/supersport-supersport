package com.uhutu.dcom.user.z.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.uhutu.dcom.user.z.entity.UcUserinfoSocial;

/**
 * 社交类用户信息数据操作
 * @author pang_jhui
 *
 */

public interface IUserInfoSocialDao extends CrudRepository<UcUserinfoSocial, String> {
	
	@Query("select t from UcUserinfoSocial t where userCode=:userCode")
	public UcUserinfoSocial queryByUserCode(@Param("userCode") String userCode);

}
