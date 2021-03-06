package com.uhutu.dcom.content.z.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 内容数据操作
 * 
 * @author pang_jhui
 *
 */
@Component
public class ContentDaoFactory {

	@Autowired
	private IContentDetailDao contentDetailDao;

	@Autowired
	private IAdvertiseDetailDao advertiseDetailDao;

	@Autowired
	private IContentBasicinfoDao contentBasicinfoDao;

	@Autowired
	private IContentItemDao contentItemDao;

	@Autowired
	private ISupportPraiseDao supportPraiseDao;

	@Autowired
	private IAdvertiseInfoDao advertiseInfoDao;

	@Autowired
	private IContentCategoryDao contentCategoryDao;

	@Autowired
	private ISportCategoryDao sportCategoryDao;
	
	@Autowired
	private IContentPhotosDao contentPhotosDao;
	
	@Autowired
	private IContentRecommDao contentRecommDao;

	public IContentDetailDao getContentDetailDao() {
		return contentDetailDao;
	}

	public IAdvertiseDetailDao getAdvertiseDetailDao() {
		return advertiseDetailDao;
	}

	public IContentBasicinfoDao getContentBasicinfoDao() {
		return contentBasicinfoDao;
	}

	public IContentItemDao getContentItemDao() {
		return contentItemDao;
	}

	public ISupportPraiseDao getSupportPraiseDao() {
		return supportPraiseDao;
	}

	public IAdvertiseInfoDao getAdvertiseInfoDao() {
		return advertiseInfoDao;
	}

	public IContentCategoryDao getContentCategoryDao() {
		return contentCategoryDao;
	}

	public ISportCategoryDao getSportCategoryDao() {
		return sportCategoryDao;
	}

	public IContentPhotosDao getContentPhotosDao() {
		return contentPhotosDao;
	}

	public IContentRecommDao getContentRecommDao() {
		return contentRecommDao;
	}

}
