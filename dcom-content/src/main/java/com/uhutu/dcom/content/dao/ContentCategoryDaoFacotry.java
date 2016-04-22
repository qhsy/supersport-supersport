package com.uhutu.dcom.content.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 分类数据facotry
 * 
 * @author xiegj
 *
 */
@Component
public class ContentCategoryDaoFacotry {

	@Autowired
	private IContentCategoryDao contentCategoryDao;

	/**
	 * 分类业务数据访问
	 * 
	 */
	public IContentCategoryDao getContentCategoryDao() {
		return contentCategoryDao;
	}

}
