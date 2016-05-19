package com.uhutu.dcom.user.z.service;

import java.util.List;

import com.uhutu.dcom.user.z.entity.UcAttentionInfo;

/**
 * 关注信息
 * 
 * @author xiegj
 *
 */
public interface IAttentionInfoService {

	/**
	 * 增加关注信息
	 * 
	 * @param attentionInfo
	 */
	public void save(UcAttentionInfo attentionInfo);

	/**
	 * 我关注的人
	 * 
	 * @param attention
	 *            我的用户编号
	 * @return
	 */
	public List<UcAttentionInfo> queryByAttention(String attention);

	/**
	 * 我的粉丝数
	 * 
	 * @param beAttention
	 *            我的用户编号
	 * @return
	 */
	public List<UcAttentionInfo> queryByBeAttention(String beAttention);

	/**
	 * 我对某用户的关注信息
	 * 
	 * @param attention
	 *            我的用户编号
	 * @param beAttention
	 *            对方的用户编号
	 * @return
	 */
	public UcAttentionInfo queryByBothCode(String attention, String beAttention);
	
	/**
	 * 根据用户编号查询粉丝数目
	 * @param userCode
	 * 		用户编号
	 * @param status
	 * 		状态
	 * @return 粉丝数
	 */
	public int queryFansCount(String userCode,String status);
	
	/**
	 * 根据用户编号查询关注数量
	 * @param userCode
	 * 		用户编号
	 * @param status
	 * 		状态
	 * @return 关注数量
	 */
	public int queryAttendCount(String userCode,String status);
}
