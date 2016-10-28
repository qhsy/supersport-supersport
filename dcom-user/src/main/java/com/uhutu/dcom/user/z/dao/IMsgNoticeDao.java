package com.uhutu.dcom.user.z.dao;

import java.util.List;

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
	
	@Query(value = "select t.* from uc_msg_notice t where not exists(select 1 from uc_msg_notice_user p where p.user_code =:userCode and p.notice_code=t.code) and send_type='many'",nativeQuery=true)
	public List<UcMsgNotice> queryUnReadMsgList(@Param("userCode") String userCode);

}
