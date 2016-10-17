package com.uhutu.dcom.tag.z.service;

import java.util.List;

import com.uhutu.dcom.tag.z.entity.CnContentLabel;

/**
 * 标签业务逻辑
 * 
 * @author xiegj
 *
 */

public interface IContentLabelService {

	/**
	 * 单个标签数据查询
	 * 
	 * @param za(pk)
	 * @return 标签信息
	 */
	public CnContentLabel query(String za);

	/**
	 * 个人标签数据查询
	 * 
	 * @param userCode
	 *            用户编号
	 * @return 标签信息
	 */
	public List<CnContentLabel> querybyuserCode(String userCode);

	/**
	 * 全部标签数据查询
	 *
	 * @return 标签信息
	 */
	public List<CnContentLabel> queryAll();

	/**
	 * 查询名称列表
	 * 
	 * @param codes
	 *            代码集合
	 * @return
	 */
	public List<String> queryListByCodeIn(List<String> codes);

	/**
	 * 初始化标签名称
	 * 
	 * @param tagCode
	 *            标签代码
	 * @return 标签名称
	 */
	public String initTagName(String tagCode);

	/**
	 * 根据编号查询内容标签
	 * 
	 * @param code
	 *            内容编号
	 * @return 内容标签
	 */
	public CnContentLabel queryByCode(String code);

	/**
	 * 根据标签编号查询标签实体
	 * 
	 * @param codes
	 *            多个编号以逗号隔开
	 */
	public List<CnContentLabel> getLabels(String codes);
	
	/**
	 * 查询名称列表
	 * 
	 * @param codes
	 *            代码集合
	 * @return
	 */
	public List<CnContentLabel> queryByCodeIn(List<String> codes);
	
	

}
