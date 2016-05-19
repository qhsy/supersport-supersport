package com.uhutu.dcom.user.z.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.user.z.entity.UcMsgPraise;

/**
 * 点赞消息通知dao
 * @author 逄小帅
 *
 */
public interface IMsgPraiseDao extends CrudRepository<UcMsgPraise, String> {
	
	@Query("select count(1) from UcMsgPraise t where contentAuthor=:userCode and status=:status")
	public int queryCount(@Param("userCode") String userCode,@Param("status") String status);

}
