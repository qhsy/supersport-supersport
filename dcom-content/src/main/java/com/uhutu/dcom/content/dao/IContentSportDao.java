package com.uhutu.dcom.content.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.content.entity.CnContentSport;

/**
 * 运动数据操作接口
 * 
 * @author xiegj
 *
 */
public interface IContentSportDao extends CrudRepository<CnContentSport, String> {

	/**
	 * 根据运动编号查询运动对象
	 * 
	 * @param code
	 *            运动编号
	 * @return 运动信息
	 */
	@Query("select ci from CnContentSport ci where ci.code=:code")
	public CnContentSport queryByCode(@Param("code") String code);

	/**
	 * 查询所有运动
	 * 
	 * @return 分类信息
	 */
	@Query("select cc from CnContentSport cc where 1=1")
	public List<CnContentSport> queryByParentCode();

}
