package com.uhutu.dcom.user.z.service;

import com.uhutu.dcom.user.z.entity.UcMsgAdvice;

/**
 * 意见反馈service
 * @author 逄小帅
 *
 */
public interface IMsgAdviceService {
	
	/**
	 * 意见反馈保存
	 * @param ucMsgAdvice
	 * 		意见反馈
	 */
	public void save(UcMsgAdvice ucMsgAdvice);

}
