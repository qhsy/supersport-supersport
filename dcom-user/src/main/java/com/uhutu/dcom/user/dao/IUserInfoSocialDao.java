package com.uhutu.dcom.user.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uhutu.dcom.user.entity.UcUserinfoSocial;

/**
 * 社交类用户信息数据操作
 * @author pang_jhui
 *
 */
@Repository
public interface IUserInfoSocialDao extends CrudRepository<UcUserinfoSocial, Long> {

}
