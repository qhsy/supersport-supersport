package com.uhutu.dcom.content.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhutu.dcom.content.dao.ContentBasicinfoDaoFacotry;
import com.uhutu.dcom.content.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.service.IContentBasicinfoService;

/**
 * 内容基本信息业务逻辑实现
 * 
 * @author xiegj
 */

@Service
@Transactional(readOnly = true)
public class ContentBasicinfoServiceImpl implements IContentBasicinfoService {

	@Autowired
	private ContentBasicinfoDaoFacotry contentCategoryDaoFacotry;

	@Override
	public CnContentBasicinfo queryByCode(String code) {
		return contentCategoryDaoFacotry.getContentBasicinfoDao().queryByCode(code);
	}

}
