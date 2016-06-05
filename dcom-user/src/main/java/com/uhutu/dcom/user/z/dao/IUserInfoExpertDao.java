package com.uhutu.dcom.user.z.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExpert;

/**
 * 达人用户信息dao
 * @author 逄小帅
 *
 */
public interface IUserInfoExpertDao extends JpaRepository<UcUserinfoExpert, String>,JpaSpecificationExecutor<UcUserinfoExpert> {
	
	@Query("select t from UcUserinfoExpert t where userCode=:userCode")
	public UcUserinfo queryByCode(@Param("userCode") String userCode);

}
