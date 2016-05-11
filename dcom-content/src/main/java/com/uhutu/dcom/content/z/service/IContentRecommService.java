package com.uhutu.dcom.content.z.service;

import com.uhutu.dcom.content.z.entity.CnContentRecomm;
import java.util.List;

/**
 * 内容推荐业务实现
 * @author 逄小帅
 *
 */
public interface IContentRecommService {
	
	/**
	 * 内容推荐信息
	 * @param contentRecomm
	 */
	public void save(CnContentRecomm contentRecomm);
	
	/**
	 * 根据内容编号查询
	 * @param contentCode
	 * 		内容编号
	 * @return 内容推荐信息列表
	 */
	public List<CnContentRecomm> queryByContentCode(String contentCode);
	
	/**
	 * 根据内容编号查询实体信息
	 * @param contentCode
	 * 		内容编号
	 * @return 内容推荐信息
	 */
	public CnContentRecomm queryEntityByCode(String contentCode);

}
