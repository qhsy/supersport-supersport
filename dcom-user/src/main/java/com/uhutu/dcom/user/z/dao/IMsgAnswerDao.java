package com.uhutu.dcom.user.z.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.user.z.entity.UcMsgAnswer;

/**
 * 消息通知dao
 * @author 逄小帅
 *
 */
public interface IMsgAnswerDao extends JpaRepository<UcMsgAnswer, String>,JpaSpecificationExecutor<UcMsgAnswer> {
	
	
	@Query("select t from UcMsgAnswer t where code=:code")
	public UcMsgAnswer queryByCode(@Param("code") String code);
	
	@Query(value = "select t from UcMsgAnswer t where userCode=:userCode")
	public List<UcMsgAnswer> queryMsgList(@Param("userCode") String userCode);
	
	@Query("select count(1) from UcMsgAnswer t where userCode=:userCode and status=:status")
	public int queryCount(@Param("userCode") String userCode,@Param("status") String status);

}
