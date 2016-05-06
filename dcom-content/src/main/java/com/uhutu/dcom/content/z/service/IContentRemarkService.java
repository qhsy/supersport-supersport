package com.uhutu.dcom.content.z.service;

import java.util.List;

import com.uhutu.dcom.content.z.entity.CnContentRemark;

/**
 * 评价内容业务逻辑interface
 * 
 * @author xiegj
 *
 */

public interface IContentRemarkService {
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

}
