package com.uhutu.dcom.user.z.service;

import com.uhutu.dcom.user.z.entity.UcMsgFocus;

/**
 * 消息关注
 * @author 逄小帅
 *
 */
public interface IMsgFoucService {
	
	/**
	 * 消息关注更新
	 * @param ucMsgFocus
	 */
	public void save(UcMsgFocus ucMsgFocus);
	
	/**
	 * 根据用户编号、消息类型查询
	 * @param userCode
	 * 		用户编号
	 * @param msgType
	 * 		消息类型
	 * @return 消息关注
	 */
	public UcMsgFocus query(String userCode,String msgType);

}
