package com.uhutu.dcom.user.z.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.uhutu.dcom.user.z.entity.UcMsgPraise;

/**
 * 点赞消息通知dao
 * @author 逄小帅
 *
 */
public interface IMsgPraiseDao extends JpaRepository<UcMsgPraise, String>,JpaSpecificationExecutor<UcMsgPraise> {
	
	@Query("select count(1) from UcMsgPraise t where contentAuthor=:userCode and status=:status")
	public int queryCount(@Param("userCode") String userCode,@Param("status") String status);
	
	@Modifying
	@Query("update UcMsgPraise t set t.status =:status where t.contentAuthor=:userCode and status=:whereStatus")
	public int updateReadStatus(@Param("userCode") String userCode,@Param("status") String status,@Param("whereStatus") String whereStatus);

}
