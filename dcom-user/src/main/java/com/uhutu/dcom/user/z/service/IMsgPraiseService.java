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
	
	/**
	 * 根据用户编号与读取标识查询数量
	 * @param userCode
	 * 		用户编号
	 * @param status
	 * 		
	 * @return
	 */
	public int queryCount(String userCode,String status);

}
