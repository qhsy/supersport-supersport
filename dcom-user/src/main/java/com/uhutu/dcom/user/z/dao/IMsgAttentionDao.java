package com.uhutu.dcom.user.z.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.uhutu.dcom.user.z.entity.UcMsgAttention;

/**
 * 关注消息通知dao 
 * @author 逄小帅
 *
 */
public interface IMsgAttentionDao extends JpaRepository<UcMsgAttention, String>,JpaSpecificationExecutor<UcMsgAttention> {
	
	@Query("select count(1) from UcMsgAttention t where attnUserCode=:userCode and status=:status")
	public int queryByCode(@Param("userCode") String userCode,@Param("status") String status);

}
