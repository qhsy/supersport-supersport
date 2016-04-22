package com.uhutu.dcom.content.service;

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

}
