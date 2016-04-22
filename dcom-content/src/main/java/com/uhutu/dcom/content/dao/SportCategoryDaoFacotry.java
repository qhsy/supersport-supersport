package com.uhutu.dcom.content.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 运动类型数据facotry
 * 
 * @author xiegj
 *
 */
@Component
public class SportCategoryDaoFacotry {

	@Autowired
	private ISportCategoryDao contentItemDao;

	/**
	 * 运动类型业务数据访问
	 * 
	 */
	public ISportCategoryDao getSportCategoryDao() {
		return contentItemDao;
	}

}
