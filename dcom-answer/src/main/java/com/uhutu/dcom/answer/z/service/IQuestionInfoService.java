package com.uhutu.dcom.answer.z.service;

import java.util.List;

import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;

/**
 * 问题信息业务接口
 * @author 逄小帅
 *
 */
public interface IQuestionInfoService {
	
	/**
	 * 根据用户编号查询提问问题数量
	 * @param userCode
	 * 		用户编号
	 * @return 提问的数量
	 */
	public int queryCount(String userCode);
	
	/**
	 * 根据用户编号查询问题信息列表
	 * @param userCode
	 * 		用户编号
	 * @param iStart
	 * 		开始索引
	 * @param iNumber
	 * 		查询的数量
	 * @return 问题列表
	 */
	public List<AwQuestionInfo> queryList(String userCode,int iStart, int iNumber);
	
	/**
	 * 获取我答问题数量
	 * @param userCode
	 * 		用户编号
	 * @param status
	 * 		状态
	 * @return 数量
	 */
	public int queryAnswerCount(String userCode,String status);
	
	/**
	 * 根据用户编号查询问题信息列表
	 * @param userCode
	 * 		用户编号(回答人)
	 * @param status
	 * 		状态
	 * @param iStart
	 * 		开始索引
	 * @param iNumber
	 * 		查询的数量
	 * @return 问题列表
	 */
	public List<AwQuestionInfo> queryAnswerList(String userCode,String scope,String status,int iStart, int iNumber);
	
	/**
	 * 根据问题编号获取问题信息
	 * @param code
	 * 		问题编号
	 * @return 问题信息
	 */
	public AwQuestionInfo queryByCode(String code);
	
	/**
	 * 更新问题信息状态
	 * @param awQuestionInfo
	 * 		问题信息
	 * @return 更新记录数
	 */
	public int updateStatus(AwQuestionInfo awQuestionInfo);

}
