package com.uhutu.dcom.content.z.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;

/**
 * 内容数据操作接口
 * 
 * @author xiegj
 *
 */
public interface IContentBasicinfoDao
		extends JpaRepository<CnContentBasicinfo, String>, JpaSpecificationExecutor<CnContentBasicinfo> {

	/**
	 * 根据内容编号查询内容对象
	 * 
	 * @param code
	 *            内容编号
	 * @return 内容信息
	 */
	@Query("select cc from CnContentBasicinfo cc where cc.code=:code")
	public CnContentBasicinfo queryByCode(@Param("code") String code);

	/**
	 * 根据内容分享范围查询内容对象
	 * 
	 * @param shareScope
	 *            0:不公开 1：公开 分享范围
	 * @return 内容信息
	 */
//	@Query("select cc from CnContentBasicinfo cc where cc.shareScope=:shareScope and cc.status='dzsd4699100110010001' order by cc.publishTime desc")
//	public List<CnContentBasicinfo> queryAll(@Param("shareScope") String shareScope);

	/**
	 * 根据作者查询内容对象
	 * 
	 * @param author
	 *            作者
	 *
	 * @return 内容信息
	 */
//	@Query("select cc from CnContentBasicinfo cc where cc.author=:author and cc.status='dzsd4699100110010001' order by cc.publishTime desc")
//	public List<CnContentBasicinfo> queryByAuthor(@Param("author") String author);

	/**
	 * 根据内容编号查询标题
	 * 
	 * @param code
	 *            内容编号
	 * @return 标题
	 */
	@Query("select t.title from CnContentBasicinfo t where t.code=:code")
	public String queryTitleByCode(@Param("code") String code);
	
	/**
	 * 根据内容编号查询标题
	 * 
	 * @param code
	 *            内容编号
	 * @return 标题
	 */
	@Modifying
	@Query("update CnContentBasicinfo t set t.status=:status where t.code=:code")
	public int updateStatus(@Param("code") String code,@Param("status") String status);

}
