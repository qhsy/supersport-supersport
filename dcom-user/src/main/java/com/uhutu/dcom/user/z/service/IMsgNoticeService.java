package com.uhutu.dcom.user.z.service;

import java.util.List;

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
	
	/**
	 * 查询未读消息列表
	 * @param userCode
	 * 		用户编号
	 * @return 未读消息数量
	 */
	public List<UcMsgNotice> queryUnReadMsgList(String userCode);

}
