package com.uhutu.dcom.content.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.dao.ContentDaoFactory;
import com.uhutu.dcom.content.entity.CnContentDetail;
import com.uhutu.dcom.content.service.IContentDetailService;

/**
 * 内容业务逻辑实现
 * 
 * @author xiegj
 */

@Service
public class ContentDetailServiceImpl implements IContentDetailService {

	@Autowired
	private ContentDaoFactory daoFacotry;

	@Override
	public CnContentDetail queryByCode(String code) {
		return daoFacotry.getContentDetailDao().queryByCode(code);
	}

	@Override
	public void save(CnContentDetail contentDetail) {
		
		daoFacotry.getContentDetailDao().save(contentDetail);
		
	}

}
