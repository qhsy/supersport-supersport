package com.uhutu.dcom.content.z.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.content.z.entity.CnContentDetail;

/**
 * 内容数据操作接口
 * 
 * @author xiegj
 *
 */
public interface IContentDetailDao extends CrudRepository<CnContentDetail, String> {

	/**
	 * 根据内容编号查询内容对象
	 * 
	 * @param code
	 *            内容编号
	 * @return 内容信息
	 */
	@Query("select cc from CnContentDetail cc where cc.code=:code")
	public CnContentDetail queryByCode(@Param("code") String code);

}
