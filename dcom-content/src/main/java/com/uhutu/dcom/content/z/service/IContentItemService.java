package com.uhutu.dcom.content.z.service;

import java.util.List;

import com.uhutu.dcom.content.z.entity.CnContentItem;

/**
 * 栏目业务逻辑interface
 * 
 * @author xiegj
 *
 */

public interface IContentItemService {
	/**
	 * 根据栏目编号查询分类对象
	 * 
	 * @param code
	 *            栏目编号
	 * @return 栏目信息
	 */
	public CnContentItem queryByCode(String code);

	/**
	 * 查询所有栏目信息
	 * 
	 * @return 栏目信息
	 */
	public List<CnContentItem> queryAll();

}
