package com.uhutu.dcom.content.z.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.dao.ContentDaoFactory;
import com.uhutu.dcom.content.z.entity.CnContentCategory;
import com.uhutu.dcom.content.z.service.IContentCategoryService;

/**
 * 分类业务逻辑实现
 * 
 * @author xiegj
 */

@Service
public class ContentCategoryServiceImpl implements IContentCategoryService {

	@Autowired
	private ContentDaoFactory daoFacotry;

	@Override
	public CnContentCategory queryByCode(String code) {
		return daoFacotry.getContentCategoryDao().queryByCode(code);
	}

	@Override
	public List<CnContentCategory> queryByParentCode(String parentCode) {
		return daoFacotry.getContentCategoryDao().queryByParentCode(parentCode);
	}

}
