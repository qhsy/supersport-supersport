package com.uhutu.dcom.user.z.service;

import com.uhutu.dcom.user.z.entity.UcMsgRemark;

/**
 * 评论消息通知service
 * @author 逄小帅
 *
 */
public interface IMsgRemarkService {

	/**
	 * 用户评论消息通知save
	 * @param ucMsgRemark
	 */
	public void save(UcMsgRemark ucMsgRemark);
	
	/**
	 * 根据用户编号与消息状态查询记录数量
	 * @param userCode
	 * 		用户编号
	 * @param flag
	 * 		消息状态
	 * @return 对应状态的记录数
	 */
	public int queryCount(String userCode,String flag);
	
	
	
}
