package com.uhutu.dcom.user.z.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.user.z.entity.UcUserinfoDonate;

/**
 * 用户捐赠信息
 * @author 逄小帅
 *
 */
public interface IUserInfoDonateDao extends JpaRepository<UcUserinfoDonate, String>, JpaSpecificationExecutor<String> {

	@Query("select t from UcUserinfoDonate t where userCode=:userCode")
	public UcUserinfoDonate queryByCode(@Param("userCode") String userCode);
	
}
