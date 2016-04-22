package com.uhutu.dcom.content.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhutu.dcom.content.dao.ContentDetailDaoFacotry;
import com.uhutu.dcom.content.entity.CnContentDetail;
import com.uhutu.dcom.content.service.IContentDetailService;

/**
 * 内容业务逻辑实现
 * 
 * @author xiegj
 */

@Service
@Transactional(readOnly = true)
public class ContentDetailServiceImpl implements IContentDetailService {

	@Autowired
	private ContentDetailDaoFacotry contentDetailDaoFacotry;

	@Override
	public CnContentDetail queryByCode(String code) {
		return contentDetailDaoFacotry.getCnContentDetailDao().queryByCode(code);
	}

}
