package com.uhutu.dcom.search.z.service;

import com.uhutu.dcom.search.z.entity.ResponseData;

/**
 * 视频查询
 * @author 逄小帅
 *
 */
public interface ISearchVideoService {
	
	/**
	 * 根据视频标题查询
	 * @param title
	 * 		视频标题
	 * @param start
	 * 		开始
	 * @param number
	 * 		每页查询number
	 * @return 响应数据
	 */
	public ResponseData search(String title,int start,int number);

}
