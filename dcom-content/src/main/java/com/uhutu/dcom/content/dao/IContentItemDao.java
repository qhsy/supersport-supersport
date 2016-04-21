package com.uhutu.dcom.content.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.content.entity.CnContentItem;

/**
 * 栏目数据操作接口
 * 
 * @author xiegj
 *
 */
public interface IContentItemDao extends CrudRepository<CnContentItem, String> {

	/**
	 * 根据栏目编号查询栏目对象
	 * 
	 * @param code
	 *            栏目编号
	 * @return 栏目信息
	 */
	@Query("select ci from CnContentItem ci where ci.code=:code")
	public CnContentItem queryByCode(@Param("code") String code);

//	/**
//	 * 查询所有栏目
//	 * 
//	 * @return 分类信息
//	 */
//	@Query("select cc from CnContentItem cc where 1=1")
//	public List<CnContentItem> queryByParentCode();

}
