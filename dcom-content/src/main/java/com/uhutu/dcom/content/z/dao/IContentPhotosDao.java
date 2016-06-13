package com.uhutu.dcom.content.z.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.uhutu.dcom.content.z.entity.CnContentPhotos;

public interface IContentPhotosDao extends CrudRepository<CnContentPhotos, String> {
	
	/**
	 * 根据内容编号查询图集信息
	 * 
	 * @param code
	 *            内容编号
	 * @return 内容信息
	 */
	@Query("select cc from CnContentPhotos cc where cc.contentCode=:code order by sort asc")
	public List<CnContentPhotos> queryByCode(@Param("code") String code);

}
