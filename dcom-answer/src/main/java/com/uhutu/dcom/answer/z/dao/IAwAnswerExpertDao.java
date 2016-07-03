package com.uhutu.dcom.answer.z.dao;

import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;

/**
 * 问答用户信息
 * @author 逄小帅
 *
 */
public interface IAwAnswerExpertDao {
	
	/**
	 * 根据用户编号获取用户信息
	 * @param userCode
	 * 		用户编号
	 * @return
	 */
	public AwAnswerExpert queryByCode(String userCode);
	
	/**
	 * 保存问答用户信息
	 * @param expert
	 */
	public int save(AwAnswerExpert expert);

}
