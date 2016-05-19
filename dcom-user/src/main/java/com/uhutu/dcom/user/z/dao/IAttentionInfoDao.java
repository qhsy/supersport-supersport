package com.uhutu.dcom.user.z.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uhutu.dcom.user.z.entity.UcAttentionInfo;

/**
 * 用户关注数据操作接口
 * 
 * @author xiegj
 *
 */
public interface IAttentionInfoDao extends CrudRepository<UcAttentionInfo, String> {
	/**
	 * 我关注的人
	 * 
	 * @param attention
	 *            我的用户编号
	 * @return
	 */
	@Query("select t from UcAttentionInfo t where attention=:attention")
	public List<UcAttentionInfo> queryByAttention(@Param("attention") String attention);

	/**
	 * 我的粉丝数
	 * 
	 * @param beAttention
	 *            我的用户编号
	 * @return
	 */
	@Query("select t from UcAttentionInfo t where beAttention=:beAttention")
	public List<UcAttentionInfo> queryByBeAttention(@Param("beAttention") String beAttention);

	/**
	 * 我对某用户的关注信息
	 * 
	 * @param attention
	 *            我的用户编号
	 * @return
	 */
	@Query("select t from UcAttentionInfo t where attention=:attention and beAttention=:beAttention")
	public UcAttentionInfo queryByBothCode(@Param("attention") String attention,
			@Param("beAttention") String beAttention);
	
	/**
	 * 获取粉丝数量
	 * 
	 * @param userCode
	 *        用户编号
	 * @param status
	 * 		状态
	 * @return 粉丝数量
	 */
	@Query("select count(1) from UcAttentionInfo t where beAttention=:userCode and status=:status")
	public int queryFansCount(@Param("userCode") String userCode,
			@Param("status") String status);
	
	/**
	 * 获取关注数量
	 * 
	 * @param userCode
	 *        用户编号
	 * @param status
	 * 		状态
	 * @return 关注数量
	 */
	@Query("select count(1) from UcAttentionInfo t where attention=:userCode and status=:status")
	public int queryAttendCount(@Param("userCode") String userCode,
			@Param("status") String status);
}
