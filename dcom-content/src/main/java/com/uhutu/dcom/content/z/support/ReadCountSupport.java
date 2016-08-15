package com.uhutu.dcom.content.z.support;

import com.uhutu.dcom.content.z.entity.CnContentReadCount;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 
 * 阅读量support
 * 
 * @author xiegj
 */
public class ReadCountSupport {

	/**
	 * 根据内容编号查询阅读量
	 * 
	 * @param code
	 *            内容编号
	 * @return count
	 */
	public int ReadcountByCode(String code) {
		int count = 0;
		CnContentReadCount readCount = JdbcHelper.queryOne(CnContentReadCount.class, "code", code);
		if (readCount != null) {
			count = readCount.getCount();
		}
		return count;
	}
}
