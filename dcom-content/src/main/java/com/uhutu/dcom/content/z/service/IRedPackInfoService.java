package com.uhutu.dcom.content.z.service;

import java.util.List;

import com.uhutu.dcom.content.z.entity.CnRedPackUser;

/**
 * 红包信息业务处理
 * @author 逄小帅
 *
 */
public interface IRedPackInfoService {
	
	/**
	 * 根据直播编号状态获取打赏人员信息
	 * @param liveNO
	 * 		直播编号
	 * @param status
	 * 		直播状态
	 * @return 红包用户信息
	 */
	public List<CnRedPackUser> getRedPackUsers(String liveNO, String status);

}
