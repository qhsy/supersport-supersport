package com.uhutu.dcom.user.z.service;

import org.springframework.data.domain.Page;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.entity.UcMsgRemark;

/**
 * 评论消息通知service
 * @author 逄小帅
 *
 */
public interface IMsgRemarkService {

	/**
	 * 用户评论消息通知save
	 * @param ucMsgRemark
	 */
	public void save(UcMsgRemark ucMsgRemark);
	
	/**
	 * 根据用户编号与消息状态查询记录数量
	 * @param userCode
	 * 		用户编号
	 * @param status
	 * 		消息状态
	 * @return 对应状态的记录数
	 */
	public int queryCount(String userCode,String status);
	
	/**
	 * 根据用户编号与评论状态查询分页数据
	 * 
	 * @param conditions
	 * 		查询条件
	 * @param pageNum
	 * 		页码
	 * @param 每页展示数量
	 * 		limit
	 * @return 分页数据
	 */
	public Page<UcMsgRemark> queryPageByUserCode(int pageNum, int limit, QueryConditions conditions);
	
	/**
	 * 更新为已读状态
	 * @param userCode
	 * 		用户编号
	 * @param updateStatus
	 * 		更新状态
	 * @param whereStatus
	 * 		查询状态
	 * @return 更新记录数
	 */
	public int updateReadStatus(String userCode,String updateStatus,String whereStatus);
	
	
	
}
