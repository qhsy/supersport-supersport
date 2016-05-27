package com.uhutu.dcom.user.z.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.user.z.entity.SpAppVersion;

/**
 * app版本信息
 * @author 逄小帅
 *
 */
public interface IAppVersionDao extends JpaRepository<SpAppVersion, String> {
	
	@Query(value = "select * from sp_app_version where system_type=:systemType order by zc desc limit 0,1",nativeQuery = true)
	public SpAppVersion queryOrderByZcDesc(@Param("systemType") String systemType);

}
