package com.uhutu.dcom.user.z.service;

import org.springframework.data.domain.Page;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.entity.UcMsgPraise;

/**
 * 点赞消息业务service
 * @author 逄小帅
 *
 */
public interface IMsgPraiseService {
	
	/**
	 * 用户点赞消息通知save
	 * @param ucMsgPraise
	 */
	public void save(UcMsgPraise ucMsgPraise);
	
	/**
	 * 根据用户编号与读取标识查询数量
	 * @param userCode
	 * 		用户编号
	 * @param status
	 * 		
	 * @return
	 */
	public int queryCount(String userCode,String status);
	
	/**
	 * 根据查询条件查询分页数据
	 * @param pageNum
	 * 		当前页码
	 * @param limit
	 * 		每页展示数量
	 * @param conditions
	 * 		查询条件
	 * @return 分页数据
	 */
	public Page<UcMsgPraise> queryPageByUserCode(int pageNum, int limit,QueryConditions conditions);
	
	

}
