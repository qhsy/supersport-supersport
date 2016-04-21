package com.uhutu.dcom.content.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 栏目数据facotry
 * 
 * @author xiegj
 *
 */
@Component
public class ContentItemDaoFacotry {

	@Autowired
	private IContentItemDao contentItemDao;

	/**
	 * 栏目业务数据访问
	 * 
	 */
	public IContentItemDao getContentItemDao() {
		return contentItemDao;
	}

}
