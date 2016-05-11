package com.uhutu.dcom.content.z.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.uhutu.dcom.content.z.entity.CnContentRecomm;

/**
 * 内容推荐信息数据访问
 * @author 逄小帅
 *
 */
public interface IContentRecommDao extends CrudRepository<CnContentRecomm, String> {
	
	/**
	 * 根据内容编号查询内容信息列表
	 * 
	 * @param contentCode
	 *            内容编号
	 * @return 内容信息
	 */
	@Query("select cc from CnContentRecomm cc where cc.contentCode=:contentCode")
	public List<CnContentRecomm> queryByCode(@Param("contentCode") String contentCode);
	
	/**
	 * 根据内容编号查询内容推荐信息
	 * 
	 * @param contentCode
	 *            内容编号
	 * @return 内容信息
	 */
	@Query("select cc from CnContentRecomm cc where cc.contentCode=:contentCode")
	public CnContentRecomm queryEntityByCode(@Param("contentCode") String contentCode);

}
