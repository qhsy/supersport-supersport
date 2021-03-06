package com.uhutu.dcom.content.z.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;

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
	 * 查询分页信息
	 * @param pageNum
	 * 		页码
	 * @param limit
	 * 		每页展示数量
	 * @param conditions
	 * 		查询条件
	 * @return 分页数据
	 */
	public Page<CnContentBasicinfo> queryPage(int pageNum, int limit,QueryConditions conditions);

//	public List<CnContentBasicinfo> queryAll(String shareScope);

	/**
	 * 根据作者查询内容对象
	 * 
	 * @param author 作者
	 *
	 * @return 内容信息
	 */
//	public List<CnContentBasicinfo> queryByAuthor(String author);
	
	/**
	 * 内容基本信息存储
	 * @param contentBasicinfo
	 */
	public void save(CnContentBasicinfo contentBasicinfo);
	
	/**
	 * 根据内容编号查询内容标题
	 * @param code
	 * 		内容编号
	 * @return 标题
	 */
	public String queryTitleByCode(String code);
	
	/**
	 * 更新记录状态
	 * @param code
	 * 		内容编号
	 * @param status
	 * 		内容状态
	 * @return 更新记录
	 */
	public int updateStatus(String code, String status);
}
