package com.uhutu.dcom.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.uhutu.dcom.user.entity.UcUserinfoExt;

/**
 * 用户扩展信息数据操作
 * @author pang_jhui
 *
 */
public interface IUserInfoExtDao extends CrudRepository<UcUserinfoExt, Long> {

}
