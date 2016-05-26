package com.uhutu.dcom.remark.z.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 内容评论数据访问工厂
 * @author 逄小帅
 *
 */
@Component
public class ContentRemarkDaoFactory {
	
	@Autowired
	private IContentRemarkDao contentRemarkDao;
	
	@Autowired
	private ISupportComplainDao supportComplainDao;

	public IContentRemarkDao getContentRemarkDao() {
		return contentRemarkDao;
	}

	public ISupportComplainDao getSupportComplainDao() {
		return supportComplainDao;
	}
	
	

}
