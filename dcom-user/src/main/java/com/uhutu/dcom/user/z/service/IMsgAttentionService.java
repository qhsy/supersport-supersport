package com.uhutu.dcom.user.z.service;

import com.uhutu.dcom.user.z.entity.UcMsgAttention;

/**
 * 消息关注业务处理
 * @author 逄小帅
 *
 */
public interface IMsgAttentionService {
	
	/**
	 * 用户关注消息通知save
	 * @param ucMsgAttention
	 */
	public void save(UcMsgAttention ucMsgAttention);

}
