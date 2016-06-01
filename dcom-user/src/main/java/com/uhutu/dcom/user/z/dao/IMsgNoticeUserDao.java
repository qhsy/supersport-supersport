package com.uhutu.dcom.user.z.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.uhutu.dcom.user.z.entity.UcMsgNoticeUser;

/**
 * 消息通知用户关联关系dao
 * @author 逄小帅
 *
 */
public interface IMsgNoticeUserDao extends JpaRepository<UcMsgNoticeUser, String>,JpaSpecificationExecutor<UcMsgNoticeUser> {
	
	@Query("select count(1) from UcMsgNoticeUser t where userCode=:userCode and status=:status")
	public int queryCount(@Param("userCode") String userCode,@Param("status") String status);
	
	@Modifying
	@Query("update UcMsgNoticeUser t set t.status =:status where t.userCode=:userCode and status=:whereStatus")
	public int updateReadStatus(@Param("userCode") String userCode,@Param("status") String status,@Param("whereStatus") String whereStatus);

}
