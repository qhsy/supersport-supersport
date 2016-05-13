package com.uhutu.dcom.user.z.dao;

import org.springframework.data.repository.CrudRepository;

import com.uhutu.dcom.user.z.entity.UcClientInfo;

/**
 * 用户信息数据操作接口
 * 
 * @author pang_jhui
 *
 */
public interface IClientInfoDao extends CrudRepository<UcClientInfo, String> {

}
