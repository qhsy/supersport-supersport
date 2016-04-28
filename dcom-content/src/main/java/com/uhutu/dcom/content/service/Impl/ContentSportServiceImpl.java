package com.uhutu.dcom.content.service.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uhutu.dcom.content.dao.ContentDaoFactory;
import com.uhutu.dcom.content.entity.CnContentSport;
import com.uhutu.dcom.content.service.IContentSportService;

/**
 * 运动业务逻辑实现
 * 
 * @author xiegj
 */

@Service
public class ContentSportServiceImpl implements IContentSportService {

	@Autowired
	private ContentDaoFactory daoFacotry;

	@Override
	public CnContentSport queryByCode(String code) {
		return daoFacotry.getContentSportDao().queryByCode(code);
	}

	@Override
	public List<CnContentSport> queryAll() {
		Iterable<CnContentSport> it = daoFacotry.getContentSportDao().findAll();
		List<CnContentSport> list = new ArrayList<CnContentSport>();
		Iterator<CnContentSport> ito = it.iterator();
		while (ito.hasNext()) {
			list.add(ito.next());
		}
		return list;
	}

}
