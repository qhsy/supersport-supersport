package com.uhutu.dcom.content.z.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.content.z.entity.CnSupportPraise;

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
	
	/**
	 * 根据内容编号查询
	 * @param contentCode
	 * 		内容编号
	 * @param status
	 * 		状态
	 * @return 数量
	 */
	public int queryCountByCode(String contentCode, String status);
	
	/**
	 * 是否喜欢过
	 * 
	 * @param type
	 *            点赞类型
	 * @param userCode
	 *            用户编号
	 * @param contentCode
	 *            内容编号
	 * @return 标签信息
	 */
	public int favored(String type, String userCode, String contentCode);
	
	/**
	 * 根据内容编号、用户编号、类型查询实体
	 * @param contentCode
	 * 		内容编号
	 * @param userCode
	 * 		用户编号
	 * @param type
	 * 		类型标识
	 * @return 实体类
	 */
	public CnSupportPraise query(String contentCode, String userCode, String type);
	
	
	/**
	 * 是否喜欢过
	 * 
	 * @param type
	 *            点赞类型
	 * @param userCode
	 *            用户编号
	 * @param contentCode
	 *            内容编号
	 * @return 标签信息
	 */
	public int favored(String type, String userCode);
	
	/**
	 * 根据条件查询分页信息
	 * @param pageNum
	 * 		页码
	 * @param limit
	 * 		每页展示数量
	 * @param conditions
	 * 		查询那条件
	 * @return 分页信息
	 */
	public Page<CnSupportPraise> queryPageByCondition(int pageNum, int limit, QueryConditions conditions);
	
}
