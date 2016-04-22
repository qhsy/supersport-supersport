package com.uhutu.dcom.content.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.uhutu.dcom.content.entity.CnContentRemark;

/**
 * 内容数据操作接口
 * 
 * @author xiegj
 *
 */
public interface IContentRemarkDao extends CrudRepository<CnContentRemark, String> {

	/**
	 * 根据内容编号查询内容对象
	 * 
	 * @param code
	 *            内容编号
	 * @return 内容信息
	 */
	@Query("select cc from CnContentRemark cc where cc.code=:code")
	public CnContentRemark queryByCode(@Param("code") String code);

	/**
	 * 根据内容编号查询内容对象
	 * 
	 * @param code
	 *            内容编号
	 * @return 内容信息
	 */
	@Query("select cc from CnContentRemark cc where cc.contentCode=:contentCode")
	public List<CnContentRemark> queryByContentCode(@Param("contentCode") String contentCode);
}
