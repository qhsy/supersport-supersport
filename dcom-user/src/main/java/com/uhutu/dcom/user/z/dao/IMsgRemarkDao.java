package com.uhutu.dcom.user.z.dao;

import org.springframework.data.repository.CrudRepository;
import com.uhutu.dcom.user.z.entity.UcMsgRemark;

/**
 * 消息评论通知dao
 * @author 逄小帅
 *
 */
public interface IMsgRemarkDao extends CrudRepository<UcMsgRemark, String> {

}
