package com.uhutu.dcom.content.z.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.content.z.entity.SpSportCategory;

/**
 * 运动类型数据操作接口
 * 
 * @author xiegj
 *
 */
public interface ISportCategoryDao extends CrudRepository<SpSportCategory, String> {

	/**
	 * 根据运动类型编号查询运动类型对象
	 * 
	 * @param code
	 *            运动类型编号
	 * @return 运动类型信息
	 */
	@Query("select ci from SpSportCategory ci where ci.code=:code")
	public SpSportCategory queryByCode(@Param("code") String code);

}
