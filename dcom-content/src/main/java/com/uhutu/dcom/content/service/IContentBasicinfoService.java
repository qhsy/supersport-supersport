package com.uhutu.dcom.content.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.content.entity.CnContentBasicinfo;

/**
 * 内容基本信息业务逻辑interface
 * 
 * @author xiegj
 *
 */

public interface IContentBasicinfoService {
	/**
	 * 根据内容编号查询内容基本信息对象
	 * 
	 * @param code
	 *            内容编号
	 * @return 内容基本信息
	 */
	public CnContentBasicinfo queryByCode(String code);
	
	/**
	 * 根据内容分享范围查询内容对象
	 * 
	 * @param shareScope 0:不公开  1：公开
	 *            分享范围 
	 * @return 内容信息
	 */
	public List<CnContentBasicinfo> queryAll(String shareScope);

	/**
	 * 根据作者查询内容对象
	 * 
	 * @param author 作者
	 *
	 * @return 内容信息
	 */
	public List<CnContentBasicinfo> queryByAuthor(String author);
}
