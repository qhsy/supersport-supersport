package com.uhutu.dcom.content.service;

import java.util.List;

import com.uhutu.dcom.content.entity.CnSupportPraise;

/**
 * 点赞业务逻辑interface
 * 
 * @author xiegj
 *
 */

public interface ISupportPraiseService {

	/**
	 * 个人点赞或其他类型数据查询(分类型)
	 * 
	 * @param type
	 *            点赞类型
	 * @param userCode
	 *            用户编号
	 * @return 标签信息
	 */
	public List<CnSupportPraise> querybyUserCodeAndType(String type, String userCode);

	/**
	 * 个人点赞所有数据查询
	 * 
	 * @param userCode
	 *            用户编号
	 * @return 点击评价信息
	 */
	public List<CnSupportPraise> querybyUserCode(String userCode);

	/**
	 * 内容全部点赞类型数据数据查询(不分类型)
	 * 
	 * @param contentCode
	 *            内容编号
	 * @return 点击评价信息
	 */
	public List<CnSupportPraise> querybyContentCode(String contentCode);

	/**
	 * 内容获赞 或其他类型数据查询(分类型)
	 * 
	 * @param type
	 *            点赞类型
	 * @param contentCode
	 *            内容编号
	 * 
	 * @return 点击评价信息
	 */
	public List<CnSupportPraise> querybyContentCodeAndtype(String type, String contentCode);

	/**
	 * 内容获赞保存(分类型)
	 * 
	 * @param CnSupportPraise
	 * 
	 * @return 点击评价信息
	 */
	public void save(CnSupportPraise praise);


	/**
	 * 个人点赞或其他类型数据查询(分类型)
	 * 
	 * @param type
	 *            点赞类型
	 * @param userCode
	 *            用户编号
	 * @param contentCode
	 *            内容编号
	 * @return 标签信息
	 */
	public List<CnSupportPraise> querybyContentCodeAndUserCodeAndType(String type, String userCode, String contentCode);

	/**
	 * 个人取消点赞(分类型)
	 * 
	 * @param type
	 *            点赞类型
	 * @param userCode
	 *            用户编号
	 * @param contentCode
	 *            内容编号
	 * @return 标签信息
	 */
	public void cancelbyCCAndUCAndType(String type, String userCode, String contentCode);
}