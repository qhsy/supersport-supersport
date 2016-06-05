package com.uhutu.dcom.user.z.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.uhutu.dcom.user.z.entity.UcDonateInfo;

/**
 * 用户捐赠信息dao
 * @author pang_jhui
 *
 */
public interface IUserDonateInfoDao extends JpaRepository<UcDonateInfo, String>,JpaSpecificationExecutor<UcDonateInfo> {

}
