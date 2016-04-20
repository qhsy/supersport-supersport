package com.uhutu.dcom.user.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uhutu.dcom.user.entity.UcUserinfo;

/**
 * 用户信息数据操作接口
 * @author pang_jhui
 *
 */
@Repository
public interface IUserInfoDao extends CrudRepository<UcUserinfo, String> {

}
