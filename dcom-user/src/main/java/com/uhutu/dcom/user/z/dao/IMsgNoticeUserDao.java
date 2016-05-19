package com.uhutu.dcom.user.z.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.user.z.entity.UcMsgNoticeUser;

/**
 * 消息通知用户关联关系dao
 * @author 逄小帅
 *
 */
public interface IMsgNoticeUserDao extends CrudRepository<UcMsgNoticeUser, String> {
	
	@Query("select count(1) from UcMsgNoticeUser t where userCode=:userCode and status=:status")
	public int queryCount(@Param("userCode") String userCode,@Param("status") String status);

}
