package com.uhutu.dcom.user.z.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.user.z.entity.UcMsgNotice;

/**
 * 消息通知dao
 * @author 逄小帅
 *
 */
public interface IMsgNoticeDao extends JpaRepository<UcMsgNotice, String>,JpaSpecificationExecutor<UcMsgNotice> {
	
	
	@Query("select t from UcMsgNotice t where code=:code")
	public UcMsgNotice queryByCode(@Param("code") String code);

}
