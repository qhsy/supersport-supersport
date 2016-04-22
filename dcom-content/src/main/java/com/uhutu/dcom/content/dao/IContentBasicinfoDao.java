package com.uhutu.dcom.content.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.content.entity.CnContentBasicinfo;

/**
 * 内容数据操作接口
 * 
 * @author xiegj
 *
 */
public interface IContentBasicinfoDao extends CrudRepository<CnContentBasicinfo, String> {

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
	 * @param shareScope 0:不公开  1：公开
	 *            分享范围 
	 * @return 内容信息
	 */
	@Query("select cc from CnContentBasicinfo cc where cc.shareScope=:shareScope and cc.status='1' order by cc.publishTime desc")
	public List<CnContentBasicinfo> queryAll(@Param("shareScope") String shareScope);
	
	/**
	 * 根据作者查询内容对象
	 * 
	 * @param author 作者
	 *
	 * @return 内容信息
	 */
	@Query("select cc from CnContentBasicinfo cc where cc.author=:author and cc.status='1' order by cc.publishTime desc")
	public List<CnContentBasicinfo> queryByAuthor(@Param("author") String author);
	

}
