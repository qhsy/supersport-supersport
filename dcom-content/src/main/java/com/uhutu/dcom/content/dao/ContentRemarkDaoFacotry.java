package com.uhutu.dcom.content.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 评价信息数据facotry
 * 
 * @author xiegj
 *
 */
@Component
public class ContentRemarkDaoFacotry {

	@Autowired
	private IContentRemarkDao contentRemarkDao;

	/**
	 * 分类业务数据访问
	 * 
	 */
	public IContentRemarkDao getContentRemarkDao() {
		return contentRemarkDao;
	}

}
