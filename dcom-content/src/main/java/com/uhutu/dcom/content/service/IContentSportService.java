package com.uhutu.dcom.content.service;

import java.util.List;

import com.uhutu.dcom.content.entity.CnContentSport;

/**
 * 运动业务逻辑interface
 * 
 * @author xiegj
 *
 */

public interface IContentSportService {
	/**
	 * 根据运动编号查询分类对象
	 * 
	 * @param code
	 *            运动编号
	 * @return 运动信息
	 */
	public CnContentSport queryByCode(String code);

	/**
	 * 查询所有运动信息
	 * 
	 * @return 运动信息
	 */
	public List<CnContentSport> queryAll();

}
