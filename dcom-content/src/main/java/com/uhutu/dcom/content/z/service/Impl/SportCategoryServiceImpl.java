package com.uhutu.dcom.content.z.service.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.dao.ContentDaoFactory;
import com.uhutu.dcom.content.z.entity.SpSportCategory;
import com.uhutu.dcom.content.z.service.ISportCategoryService;

/**
 * 运动类型业务逻辑实现
 * 
 * @author xiegj
 */

@Service

public class SportCategoryServiceImpl implements ISportCategoryService {

	@Autowired
	private ContentDaoFactory daoFacotry;

	@Override
	public SpSportCategory queryByCode(String code) {
		return daoFacotry.getSportCategoryDao().queryByCode(code);
	}

	@Override
	public List<SpSportCategory> queryAll() {
		Iterable<SpSportCategory> it = daoFacotry.getSportCategoryDao().findAll();
		List<SpSportCategory> list = new ArrayList<SpSportCategory>();
		Iterator<SpSportCategory> ito = it.iterator();
		while (ito.hasNext()) {
			list.add(ito.next());
		}
		return list;
	}

	@Override
	public List<String> queryListByCodeIn(List<String> codes) {
		
		return daoFacotry.getSportCategoryDao().queryListByCodeIn(codes);
		
	}

}
