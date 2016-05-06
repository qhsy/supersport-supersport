package com.uhutu.dcom.tag.z.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 标签业务数据facotry
 * 
 * @author xiegj
 *
 */
@Component
public class ContentLabelDaoFacotry {

	@Autowired
	private IContentLabelDao contentLabelDao;

	/**
	 * 标签业务数据访问
	 * 
	 */
	public IContentLabelDao getContentLabelDao() {
		return contentLabelDao;
	}

}
