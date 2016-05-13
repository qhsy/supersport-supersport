package com.uhutu.dcom.remark.z.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.remark.z.entity.CnContentRemark;
import com.uhutu.dcom.remark.z.entity.CnSupportComplain;

/**
 * 投诉接口
 * @author 逄小帅
 *
 */
public interface ISupportComplainDao extends CrudRepository<CnSupportComplain, String> {
	
	/**
	 * 根据编号查询投诉信息
	 * 
	 * @param code
	 *            编号
	 * @return 投诉信息
	 */
	@Query("select cc from CnSupportComplain cc where cc.code=:code")
	public CnContentRemark queryByCode(@Param("code") String code);
	
	/**
	 * 根据内容编号查询内容对象
	 * 
	 * @param contentCode
	 *            内容编号
	 * @return 内容信息
	 */
	@Query("select cc from CnSupportComplain cc where cc.contentCode=:contentCode")
	public CnContentRemark queryByContentCode(@Param("contentCode") String contentCode);

}
