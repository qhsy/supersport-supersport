package com.uhutu.dcom.user.z.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.uhutu.dcom.user.z.entity.UcMsgRemark;

/**
 * 消息评论通知dao
 * @author 逄小帅
 *
 */
public interface IMsgRemarkDao extends CrudRepository<UcMsgRemark, String> {
	
	@Query("select count(1) from UcMsgRemark t where contentuthor=:userCode and flag=:flag")
	public int queryCount(@Param("userCode") String userCode,@Param("flag") String flag);

}
