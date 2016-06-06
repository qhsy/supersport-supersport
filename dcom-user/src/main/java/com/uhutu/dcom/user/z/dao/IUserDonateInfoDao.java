package com.uhutu.dcom.user.z.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.user.z.entity.UcDonateInfo;

/**
 * 用户捐赠信息dao
 * @author pang_jhui
 *
 */
public interface IUserDonateInfoDao extends JpaRepository<UcDonateInfo, String>,JpaSpecificationExecutor<UcDonateInfo> {
	
	@Query("select t from UcDonateInfo t where supportCode=:supportCode and beSupportCode =: beSupportCode ")
	public UcDonateInfo queryByCode(@Param("supportCode") String supportCode,@Param("beSupportCode") String beSupportCode);

}
