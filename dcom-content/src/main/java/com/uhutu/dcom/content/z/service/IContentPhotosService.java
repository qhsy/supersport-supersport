package com.uhutu.dcom.content.z.service;

import java.util.List;

import com.uhutu.dcom.content.z.entity.CnContentPhotos;

/**
 * 内容图集业务实现
 * @author pang_jhui
 *
 */
public interface IContentPhotosService {
	
	/**
	 * 内容信息保存
	 * @param cnContentPhotos
	 */
	public void save(List<CnContentPhotos> cnContentPhotos);
	
	/**
	 * 根据内容编号查询图集信息
	 * @param code
	 * 		内容编号
	 * @return 图集列表
	 */
	public List<CnContentPhotos> queryByContentCode(String code);

	/**
	 * 内容图集
	 * @param cnContentPhotos
	 */
	public void save(CnContentPhotos cnContentPhotos);
	
}
