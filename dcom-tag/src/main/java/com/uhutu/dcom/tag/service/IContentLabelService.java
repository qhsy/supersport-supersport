package com.uhutu.dcom.tag.service;

import java.util.List;

import com.uhutu.dcom.tag.entity.CnContentLabel;

/**
 * 标签业务逻辑
 * 
 * @author xiegj
 *
 */

public interface IContentLabelService {

	/**
	 * 单个标签数据查询
	 * @param za(pk)
	 * @return 标签信息
	 */
	public CnContentLabel query(String za);
	
	/**
	 * 个人标签数据查询
	 * @param userCode 用户编号
	 * @return 标签信息
	 */
	public List<CnContentLabel> querybyuserCode(String userCode);
	
	/**
	 * 全部标签数据查询
	 *
	 * @return 标签信息
	 */
	public List<CnContentLabel> queryAll();
}
