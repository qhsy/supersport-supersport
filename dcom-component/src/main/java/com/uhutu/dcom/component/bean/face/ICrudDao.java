package com.uhutu.dcom.component.bean.face;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

/**
 * crud数据操作
 * @author pang_jhui
 * @param <T>
 *
 */
public interface ICrudDao<T, ID extends Serializable> extends CrudRepository<T, ID> {

}
