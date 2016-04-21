package com.uhutu.dcom.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.uhutu.dcom.user.entity.UcUserinfoSocial;

/**
 * 社交类用户信息数据操作
 * @author pang_jhui
 *
 */

public interface IUserInfoSocialDao extends CrudRepository<UcUserinfoSocial, String> {

}
