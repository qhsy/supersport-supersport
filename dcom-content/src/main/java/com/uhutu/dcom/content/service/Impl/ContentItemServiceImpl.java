package com.uhutu.dcom.content.service.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhutu.dcom.content.dao.ContentItemDaoFacotry;
import com.uhutu.dcom.content.entity.CnContentItem;
import com.uhutu.dcom.content.service.IContentItemService;

/**
 * 栏目业务逻辑实现
 * 
 * @author xiegj
 */

@Service
@Transactional(readOnly = true)
public class ContentItemServiceImpl implements IContentItemService {

	@Autowired
	private ContentItemDaoFacotry contentItemDaoFacotry;

	@Override
	public CnContentItem queryByCode(String code) {
		return contentItemDaoFacotry.getContentItemDao().queryByCode(code);
	}

	@Override
	public List<CnContentItem> queryAll() {
		Iterable<CnContentItem> it = contentItemDaoFacotry.getContentItemDao().findAll();
		List<CnContentItem> list = new ArrayList<CnContentItem>();
		Iterator<CnContentItem> ito = it.iterator();
		while (ito.hasNext()) {
			list.add(ito.next());
		}
		return list;
	}

}
