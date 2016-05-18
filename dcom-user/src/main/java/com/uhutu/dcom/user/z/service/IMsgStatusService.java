package com.uhutu.dcom.user.z.service;

import com.uhutu.dcom.user.z.entity.UcMsgStatus;

/**
 * 消息状态service接口
 * @author 逄小帅
 *
 */
public interface IMsgStatusService {
	
	/**
	 * 用户消息状态
	 * @param ucUserinfoExt
	 */
	public void save(UcMsgStatus ucMsgStatus);

}
