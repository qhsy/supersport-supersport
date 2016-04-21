package com.uhutu.dcom.content.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.content.entity.CnContentBasicinfo;

/**
 * 内容数据操作接口
 * 
 * @author xiegj
 *
 */
public interface IContentBasicinfoDao extends CrudRepository<CnContentBasicinfo, String> {

	/**
	 * 根据内容编号查询内容对象
	 * 
	 * @param code
	 *            内容编号
	 * @return 内容信息
	 */
	@Query("select cc from CnContentBasicinfo cc where cc.code=:code")
	public CnContentBasicinfo queryByCode(@Param("code") String code);

}
