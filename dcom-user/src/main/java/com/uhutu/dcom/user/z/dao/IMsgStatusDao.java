package com.uhutu.dcom.user.z.dao;

import org.springframework.data.repository.CrudRepository;
import com.uhutu.dcom.user.z.entity.UcMsgStatus;

/**
 * 消息状态dao
 * @author 逄小帅
 *
 */
public interface IMsgStatusDao extends CrudRepository<UcMsgStatus, String> {

}
