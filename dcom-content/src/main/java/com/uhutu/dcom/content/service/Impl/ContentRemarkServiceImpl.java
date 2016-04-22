package com.uhutu.dcom.content.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.uhutu.dcom.content.dao.ContentRemarkDaoFacotry;
import com.uhutu.dcom.content.entity.CnContentRemark;
import com.uhutu.dcom.content.service.IContentRemarkService;

/**
 * 内容基本信息业务逻辑实现
 * 
 * @author xiegj
 */

@Service
@Transactional(readOnly = true)
public class ContentRemarkServiceImpl implements IContentRemarkService {

	@Autowired
	private ContentRemarkDaoFacotry contentRemarkDaoFacotry;

	@Override
	public CnContentRemark queryByCode(String code) {
		return contentRemarkDaoFacotry.getContentRemarkDao().queryByCode(code);
	}

	@Override
	public List<CnContentRemark> queryByContentCode(String contentCode) {
		return contentRemarkDaoFacotry.getContentRemarkDao().queryByContentCode(contentCode);
	}

}
