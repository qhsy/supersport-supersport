package com.uhutu.dcom.component.bean.face;

import java.io.Serializable;

/**
 * crud业务操作
 * @author pang_jhui
 *
 */
public interface ICrudService<T, ID extends Serializable> {
	
	/***
	 * 实体更新
	 * @param entity
	 * 		业务实体
	 * @return 保存后的实体
	 */
	public <S extends T> S save(S entity);
	
	/***
	 * 
	 * 根据主键查询实体
	 *  
	 * @return 实体
	 */
	public T findOne(ID id);

}
