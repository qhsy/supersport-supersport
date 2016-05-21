package com.uhutu.dcom.user.z.service;

import com.uhutu.dcom.user.z.entity.UcMsgNotice;

/**
 * 系统消息通知service
 * @author 逄小帅
 *
 */
public interface IMsgNoticeService {
	
	/**
	 * 用户消息通知save
	 * @param ucMsgAttention
	 */
	public void save(UcMsgNotice ucMsgNotice);
	
	/**
	 * 根据编号查询消息通知
	 * @param code
	 * 		消息编号
	 * @return 消息通知
	 */
	public UcMsgNotice queryByCode(String code);

}
