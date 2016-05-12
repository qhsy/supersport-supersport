package com.uhutu.dcom.remark.z.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.remark.z.entity.CnContentRemark;

/**
 * 内容评论业务接口
 * @author 逄小帅
 *
 */
public interface IContentRemarkService {
	
	/**
	 * 内容评论信息保存
	 * @param cnContentRemark
	 */
	public void save(CnContentRemark cnContentRemark);
	
	/**
	 * 根据内容编号查询分页信息
	 * @param conditions
	 * 		分页查询条件
	 * @param pageNum
	 * 		页码
	 * @param limit
	 * 		每页展示数量
	 * @return 返回分页信息
	 */
	public Page<CnContentRemark> queryPage(int pageNum,int limit,QueryConditions conditions);

	/**
	 * 根据评论编号查询评论基本信息对象
	 * 
	 * @param code
	 *            评论编号
	 * @return 评论内容基本信息
	 */
	public CnContentRemark queryByCode(String code);

	/**
	 * 根据评论编号查询评论基本信息对象
	 * 
	 * @param contentCode
	 *            内容编号
	 * @return 评论内容基本信息
	 */
	public List<CnContentRemark> queryByContentCode(String contentCode);
	
	/**
	 * 根据内容编号查询数量
	 * @param contentCode
	 * 		内容编号
	 * @return 数量
	 */
	public int queryCount(String contentCode);
	
}
