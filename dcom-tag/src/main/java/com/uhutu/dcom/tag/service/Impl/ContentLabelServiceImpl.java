package com.uhutu.dcom.tag.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhutu.dcom.tag.dao.ContentLabelDaoFacotry;
import com.uhutu.dcom.tag.entity.CnContentLabel;
import com.uhutu.dcom.tag.service.IContentLabelService;

/**
 * 标签业务逻辑实现
 * 
 * @author xiegj
 */

@Service
@Transactional(readOnly = true)
public class ContentLabelServiceImpl implements IContentLabelService {

	@Autowired
	private ContentLabelDaoFacotry contentLabelDaoFacotry;

	public CnContentLabel query(String za) {
		return contentLabelDaoFacotry.getContentLabelDao().findOne(za);
	}

	@Override
	public List<CnContentLabel> queryAll() {
		List<CnContentLabel> list = new ArrayList<CnContentLabel>();
		list = contentLabelDaoFacotry.getContentLabelDao().queryAll();
		return list;
	}

	@Override
	public List<CnContentLabel> querybyuserCode(String userCode) {
		return contentLabelDaoFacotry.getContentLabelDao().querybyuserCode(userCode);
	}

}
