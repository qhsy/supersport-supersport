package com.uhutu.dcom.user.z.dao;

import org.springframework.data.repository.CrudRepository;
import com.uhutu.dcom.user.z.entity.UcMsgNotice;

/**
 * 消息通知dao
 * @author 逄小帅
 *
 */
public interface IMsgNoticeDao extends CrudRepository<UcMsgNotice, String> {
	
	

}
