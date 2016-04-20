package com.uhutu.dcom.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.uhutu.dcom.user.entity.UcUserinfo;

/**
 * 用户信息数据操作接口
 * @author pang_jhui
 *
 */
public interface IUserInfoDao extends CrudRepository<UcUserinfo, String> {

}
