package com.uhutu.dcom.user.z.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uhutu.dcom.user.z.entity.UcDonateFlow;

/**
 * 捐赠流水
 * @author 逄小帅
 *
 */
public interface IUserDonateFlowDao extends JpaRepository<UcDonateFlow, String> {

}
