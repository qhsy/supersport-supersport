package com.uhutu.dcom.content.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.uhutu.dcom.content.dao.ContentCategoryDaoFacotry;
import com.uhutu.dcom.content.entity.CnContentCategory;
import com.uhutu.dcom.content.service.IContentCategoryService;

/**
 * 分类业务逻辑实现
 * 
 * @author xiegj
 */

@Service
@Transactional(readOnly = true)
public class ContentCategoryServiceImpl implements IContentCategoryService {

	@Autowired
	private ContentCategoryDaoFacotry contentCategoryDaoFacotry;

	@Override
	public CnContentCategory queryByCode(String code) {
		return contentCategoryDaoFacotry.getContentCategoryDao().queryByCode(code);
	}

	@Override
	public List<CnContentCategory> queryByParentCode(String parentCode) {
		return contentCategoryDaoFacotry.getContentCategoryDao().queryByParentCode(parentCode);
	}

}
