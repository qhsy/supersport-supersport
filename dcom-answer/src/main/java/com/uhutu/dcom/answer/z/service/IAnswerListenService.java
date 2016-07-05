package com.uhutu.dcom.answer.z.service;

import java.util.List;

import com.uhutu.dcom.answer.z.entity.AwAnswerListen;

/**
 * 问答偷听信息
 * @author 逄小帅
 *
 */
public interface IAnswerListenService {
	
	/**
	 * 根据用户编号获取偷听信息
	 * @param userCode
	 * 		用户编号
	 * @return 偷听信息
	 */
	public List<AwAnswerListen> queryList(String userCode,int iStart,int iNumber);
	
	/**
	 * 查询记录数
	 * @param userCode
	 * 		用户编号
	 * @return 记录数
	 */
	public int queryCount(String userCode);

}
