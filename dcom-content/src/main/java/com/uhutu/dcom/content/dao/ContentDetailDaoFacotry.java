package com.uhutu.dcom.content.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 内容数据facotry
 * 
 * @author xiegj
 *
 */
@Component
public class ContentDetailDaoFacotry {

	@Autowired
	private IContentDetailDao cnContentDetailDao;

	/**
	 * 分类业务数据访问
	 * 
	 */
	public IContentDetailDao getCnContentDetailDao() {
		return cnContentDetailDao;
	}

}
