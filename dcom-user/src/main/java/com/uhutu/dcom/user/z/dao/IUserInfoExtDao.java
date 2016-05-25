package com.uhutu.dcom.user.z.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.user.z.entity.UcUserinfoExt;

/**
 * 用户扩展信息数据操作
 * @author pang_jhui
 *
 */
public interface IUserInfoExtDao extends CrudRepository<UcUserinfoExt, String> {
	
	@Query("select t from UcUserinfoExt t where userCode=:userCode")
	public UcUserinfoExt queryByUserCode(@Param("userCode") String userCode);
	
	@Query("select t from UcUserinfoExt t where nickName=:nickName")
	public UcUserinfoExt queryByNickName(@Param("nickName") String nickName);

}
