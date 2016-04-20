package com.uhutu.dcom.content.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 点赞业务数据facotry
 * 
 * @author xiegj
 *
 */
@Component
public class SupportPraiseDaoFacotry {

	@Autowired
	private ISupportPraiseDao supportPraiseDao;

	/**
	 * 标签业务数据访问
	 * 
	 */
	public ISupportPraiseDao getSupportPraiseDao() {
		return supportPraiseDao;
	}

}
