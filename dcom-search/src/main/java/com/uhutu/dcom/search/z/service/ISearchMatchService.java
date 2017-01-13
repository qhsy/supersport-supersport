package com.uhutu.dcom.search.z.service;

import com.uhutu.dcom.search.z.entity.ResponseData;

public interface ISearchMatchService {
	
	/**
	 * 根据赛事标题查询
	 * @param title
	 * 		赛事标题
	 * @param start
	 * 		开始
	 * @param number
	 * 		每页查询number
	 * @return 响应数据
	 */
	public ResponseData search(String title,int start,int number);

}
