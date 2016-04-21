package com.uhutu.dcom.content.service.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.uhutu.dcom.content.dao.SportCategoryDaoFacotry;
import com.uhutu.dcom.content.entity.SpSportCategory;
import com.uhutu.dcom.content.service.ISportCategoryService;

/**
 * 运动类型业务逻辑实现
 * 
 * @author xiegj
 */

@Service
@Transactional(readOnly = true)
public class SportCategoryServiceImpl implements ISportCategoryService {

	@Autowired
	private SportCategoryDaoFacotry sportCategoryDaoFacotry;

	@Override
	public SpSportCategory queryByCode(String code) {
		return sportCategoryDaoFacotry.getSportCategoryDao().queryByCode(code);
	}

	@Override
	public List<SpSportCategory> queryAll() {
		Iterable<SpSportCategory> it = sportCategoryDaoFacotry.getSportCategoryDao().findAll();
		List<SpSportCategory> list = new ArrayList<SpSportCategory>();
		Iterator<SpSportCategory> ito = it.iterator();
		while (ito.hasNext()) {
			list.add(ito.next());
		}
		return list;
	}

}
