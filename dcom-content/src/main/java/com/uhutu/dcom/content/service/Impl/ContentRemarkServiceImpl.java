package com.uhutu.dcom.content.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.dao.ContentDaoFactory;
import com.uhutu.dcom.content.entity.CnContentRemark;
import com.uhutu.dcom.content.service.IContentRemarkService;

/**
 * 内容基本信息业务逻辑实现
 * 
 * @author xiegj
 */

@Service
public class ContentRemarkServiceImpl implements IContentRemarkService {

	@Autowired
	private ContentDaoFactory daoFacotry;

	@Override
	public CnContentRemark queryByCode(String code) {
		return daoFacotry.getContentRemarkDao().queryByCode(code);
	}

	@Override
	public List<CnContentRemark> queryByContentCode(String contentCode) {
		return daoFacotry.getContentRemarkDao().queryByContentCode(contentCode);
	}

}
