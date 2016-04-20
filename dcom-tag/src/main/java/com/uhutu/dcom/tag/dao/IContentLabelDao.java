package com.uhutu.dcom.tag.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.uhutu.dcom.tag.entity.CnContentLabel;

/**
 * 标签业务数据操作接口
 * 
 * @author xiegj
 *
 */
public interface IContentLabelDao extends CrudRepository<CnContentLabel, String> {
	
	
	/**
	 * 个人标签数据查询
	 * @param userCode 用户编号
	 * @return 标签信息
	 */
	@Query("select cc from CnContentLabel cc where cc.type=:userCode")
	public List<CnContentLabel> querybyuserCode(@Param("userCode") String  userCode);
	
	
	/**
	 * 全部标签数据查询
	 *
	 * @return 标签信息
	 */
	@Query("select cc from CnContentLabel cc where 1=1")
	public List<CnContentLabel> queryAll();
}
