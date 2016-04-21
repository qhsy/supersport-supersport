package com.uhutu.dcom.component.bean.face.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import com.uhutu.dcom.component.bean.face.ICrudDao;
import com.uhutu.dcom.component.bean.face.ICrudService;

/**
 * crud业务处理
 * @author pang_jhui
 * @param <T>
 *
 */
public class BaseCrudService<T,ID extends Serializable> implements ICrudService<T, ID> {

	@Autowired
	private ICrudDao<T,ID> curdDao;
	
	@Override
	public <S extends T> S save(S entity) {
		
		return curdDao.save(entity);
		
	}

	@Override
	public T findOne(ID id) {
		
		return curdDao.findOne(id);
		
	}
	
	

}
