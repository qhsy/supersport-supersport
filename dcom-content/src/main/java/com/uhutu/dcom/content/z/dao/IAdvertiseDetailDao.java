package com.uhutu.dcom.content.z.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.content.z.entity.CnAdvertiseDetail;

/**
 * 广告数据操作接口
 * 
 * @author xiegj
 *
 */
public interface IAdvertiseDetailDao extends CrudRepository<CnAdvertiseDetail, String> {

	/**
	 * 根据广告编号查询广告信息
	 * 
	 * @return 广告信息
	 */
	@Query("select cc from CnAdvertiseDetail cc where cc.code=:code")
	public List<CnAdvertiseDetail> queryByCode(@Param("code") String code);
}
