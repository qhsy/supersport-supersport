package com.uhutu.dcom.user.z.service;

import com.uhutu.dcom.user.z.entity.UcMsgPraise;

/**
 * 点赞消息业务service
 * @author 逄小帅
 *
 */
public interface IMsgPraiseService {
	
	/**
	 * 用户点赞消息通知save
	 * @param ucMsgPraise
	 */
	public void save(UcMsgPraise ucMsgPraise);

}
