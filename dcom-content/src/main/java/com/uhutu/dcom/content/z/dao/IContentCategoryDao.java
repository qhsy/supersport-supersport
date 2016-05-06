package com.uhutu.dcom.content.z.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.content.z.entity.CnContentCategory;

/**
 * 分类数据操作接口
 * 
 * @author xiegj
 *
 */
public interface IContentCategoryDao extends CrudRepository<CnContentCategory, String> {

	/**
	 * 根据分类编号查询分类对象
	 * 
	 * @param code
	 *            分类编号
	 * @return 分类信息
	 */
	@Query("select cc from CnContentCategory cc where cc.code=:code")
	public CnContentCategory queryByCode(@Param("code") String code);

	/**
	 * 根据父分类编号查询下属分类对象
	 * 
	 * @param code
	 *            分类编号
	 * @return 分类信息
	 */
	@Query("select cc from CnContentCategory cc where cc.parentCode=:parentCode")
	public List<CnContentCategory> queryByParentCode(@Param("parentCode") String parentCode);

}
