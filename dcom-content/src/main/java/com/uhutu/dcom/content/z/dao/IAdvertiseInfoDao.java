package com.uhutu.dcom.content.z.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.content.z.entity.CnAdvertiseInfo;

/**
 * 广告数据操作接口
 * 
 * @author xiegj
 *
 */
public interface IAdvertiseInfoDao extends CrudRepository<CnAdvertiseInfo, String> {

	/**
	 * 查询已发布广告
	 * 
	 * @return 广告信息
	 */
	@Query("select cc from CnAdvertiseInfo cc where cc.status='1'")
	public List<CnAdvertiseInfo> queryAll();

	/**
	 * 根据广告编号查询广告信息
	 * 
	 * @return 广告信息
	 */
	@Query("select cc from CnAdvertiseInfo cc where cc.code=:code")
	public CnAdvertiseInfo queryByCode(@Param("code") String code);
}
