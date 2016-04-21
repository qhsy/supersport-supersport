package com.uhutu.dcom.content.service;

import com.uhutu.dcom.content.entity.CnContentDetail;

/**
 * 内容业务逻辑interface
 * 
 * @author xiegj
 *
 */

public interface IContentDetailService {
	/**
	 * 根据内容编号查询内容对象
	 * 
	 * @param code
	 *            内容编号
	 * @return 内容信息
	 */
	public CnContentDetail queryByCode(String code);

}
