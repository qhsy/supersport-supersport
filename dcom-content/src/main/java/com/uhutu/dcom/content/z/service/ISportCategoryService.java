package com.uhutu.dcom.content.z.service;

import java.util.List;

import com.uhutu.dcom.content.z.entity.SpSportCategory;

/**
 * 运动类型业务逻辑interface
 * 
 * @author xiegj
 *
 */

public interface ISportCategoryService {
	/**
	 * 根据运动类型编号查询分类对象
	 * 
	 * @param code
	 *            运动类型编号
	 * @return 运动类型信息
	 */
	public SpSportCategory queryByCode(String code);

	/**
	 * 查询所有运动类型信息
	 * 
	 * @return 运动类型信息
	 */
	public List<SpSportCategory> queryAll();

}
