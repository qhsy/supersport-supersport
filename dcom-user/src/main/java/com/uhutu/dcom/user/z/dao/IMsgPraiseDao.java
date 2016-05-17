package com.uhutu.dcom.user.z.dao;

import org.springframework.data.repository.CrudRepository;

import com.uhutu.dcom.user.z.entity.UcMsgPraise;

/**
 * 点赞消息通知dao
 * @author 逄小帅
 *
 */
public interface IMsgPraiseDao extends CrudRepository<UcMsgPraise, String> {

}
