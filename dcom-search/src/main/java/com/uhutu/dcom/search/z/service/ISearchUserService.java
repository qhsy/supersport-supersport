package com.uhutu.dcom.search.z.service;

import com.uhutu.dcom.search.z.entity.ResponseData;

/**
 * 搜索用户
 * @author 逄小帅
 *
 */
public interface ISearchUserService {
	
	/**
	 * 根据用户昵称查询
	 * @param nickName
	 * 		昵称
	 * @param start
	 * 		开始
	 * @param number
	 * 		每页查询number
	 * @return 响应数据
	 */
	public ResponseData search(String nickName,int start,int number);

}
