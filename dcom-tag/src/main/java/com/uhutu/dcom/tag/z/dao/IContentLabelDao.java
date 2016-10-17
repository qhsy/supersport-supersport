package com.uhutu.dcom.tag.z.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.tag.z.entity.CnContentLabel;

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
	
	/**
	 * 根据编号查询标签信息
	 * @param code
	 * 		编号
	 * @return 内容标签列表
	 */
	@Query("select ci.name from CnContentLabel ci where ci.code in:codes and ci.labelType='dzsd4124100110010002'")
	public List<String> queryListByCodeIn(@Param("codes") List<String> codes);
	
	/**
	 * 根据编号查询标签信息
	 * @param code
	 * 		编号
	 * @return 内容标签列表
	 */
	@Query("select ci from CnContentLabel ci where ci.code=:code")
	public CnContentLabel queryByCode(@Param("code") String code);
	
	/**
	 * 根据编号查询标签信息
	 * @param code
	 * 		编号
	 * @return 内容标签列表
	 */
	@Query("select ci from CnContentLabel ci where ci.code in:codes and ci.labelType='dzsd4124100110010002'")
	public List<CnContentLabel> queryByCodeIn(@Param("codes") List<String> codes);
	
}
