package com.uhutu.dcom.content.z.service;

import java.util.List;

import com.uhutu.dcom.content.z.entity.CnContentCategory;

/**
 * 分类业务逻辑interface
 * 
 * @author xiegj
 *
 */

public interface IContentCategoryService {
	/**
	 * 根据分类编号查询分类对象
	 * 
	 * @param code
	 *            分类编号
	 * @return 分类信息
	 */
	public CnContentCategory queryByCode(String code);

	/**
	 * 根据父分类编号查询下属分类对象
	 * 
	 * @param code
	 *            分类编号
	 * @return 分类信息
	 */
	public List<CnContentCategory> queryByParentCode(String parentCode);

}
