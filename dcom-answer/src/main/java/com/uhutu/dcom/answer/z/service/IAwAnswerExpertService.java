package com.uhutu.dcom.answer.z.service;

import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;

/**
 * 问答信息业务实现
 * @author 逄小帅
 *
 */
public interface IAwAnswerExpertService {
	
	/**
	 * 根据用户编号查询信息
	 * @param code
	 * 		用户编号
	 * @return 达人用户信息
	 */
	public AwAnswerExpert getByUserCode(String userCode);

}
