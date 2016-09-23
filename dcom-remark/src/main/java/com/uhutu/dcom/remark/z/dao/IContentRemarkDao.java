package com.uhutu.dcom.remark.z.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.remark.z.entity.CnContentRemark;

/**
 * 内容评论相关操作
 * @author 逄小帅
 *
 */
public interface IContentRemarkDao extends JpaRepository<CnContentRemark, String>,JpaSpecificationExecutor<CnContentRemark> {

	/**
	 * 根据内容编号查询内容对象
	 * 
	 * @param code
	 *            内容编号
	 * @return 内容信息
	 */
	@Query("select cc from CnContentRemark cc where cc.code=:code and cc.status=:status")
	public CnContentRemark queryByCode(@Param("code") String code,@Param("status") String status);

	/**
	 * 根据内容编号查询内容对象
	 * 
	 * @param code
	 *            内容编号
	 * @return 内容信息
	 */
	@Query("select cc from CnContentRemark cc where cc.contentCode=:contentCode")
	public List<CnContentRemark> queryByContentCode(@Param("contentCode") String contentCode);
	
	/**
	 * 根据内容编号查询内容对象
	 * 
	 * @param code
	 *            内容编号
	 * @return 内容信息
	 */
	@Query("select count(1) from CnContentRemark cc where cc.contentCode=:contentCode and status=:status")
	public int queryCount(@Param("contentCode") String contentCode,@Param("status") String status);
	
}
