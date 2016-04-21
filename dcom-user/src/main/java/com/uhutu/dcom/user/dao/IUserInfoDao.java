package com.uhutu.dcom.user.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.user.entity.UcUserinfo;

/**
 * 用户信息数据操作接口
 * @author pang_jhui
 *
 */
public interface IUserInfoDao extends CrudRepository<UcUserinfo, String> {
	
	@Query("select t from UcUserinfo t where code=:code")
	public UcUserinfo queryByCode(@Param("code") String code);
	
	@Query("select t from UcUserinfo t where loginName=:loginName")
	public UcUserinfo queryByLoginName(@Param("loginName") String loginName);

}
