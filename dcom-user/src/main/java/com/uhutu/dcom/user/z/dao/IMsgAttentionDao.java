package com.uhutu.dcom.user.z.dao;

import org.springframework.data.repository.CrudRepository;

import com.uhutu.dcom.user.z.entity.UcMsgAttention;

/**
 * 关注消息通知dao 
 * @author 逄小帅
 *
 */
public interface IMsgAttentionDao extends CrudRepository<UcMsgAttention, String> {

}
