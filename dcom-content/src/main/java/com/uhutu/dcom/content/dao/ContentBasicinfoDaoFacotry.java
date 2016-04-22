package com.uhutu.dcom.content.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 内容基本信息数据facotry
 * 
 * @author xiegj
 *
 */
@Component
public class ContentBasicinfoDaoFacotry {

	@Autowired
	private IContentBasicinfoDao contentBasicinfoDao;

	/**
	 * 分类业务数据访问
	 * 
	 */
	public IContentBasicinfoDao getContentBasicinfoDao() {
		return contentBasicinfoDao;
	}

}
