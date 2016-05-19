package com.uhutu.dcom.user.z.service;

import java.util.List;

import com.uhutu.dcom.user.z.entity.UcMsgNoticeUser;

/**
 * 消息通知用户service
 * @author 逄小帅
 *
 */
public interface IMsgNoticeUserService {
	
	/**
	 * 保存通知用户关联列表
	 * @param msgNoticeUsers
	 */
	public void save(List<UcMsgNoticeUser> msgNoticeUsers);
	
	/**
	 * 根据用户编号查询记录数量
	 * @param userCode
	 * 		用户编号
	 * @param status
	 * 		读取标识
	 * @return 未读记录数量
	 */
	public int queryCount(String userCode,String status);

}
