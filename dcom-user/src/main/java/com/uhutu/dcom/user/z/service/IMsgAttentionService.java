package com.uhutu.dcom.user.z.service;

import org.springframework.data.domain.Page;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.entity.UcMsgAttention;

/**
 * 消息关注业务处理
 * @author 逄小帅
 *
 */
public interface IMsgAttentionService {
	
	/**
	 * 用户关注消息通知save
	 * @param ucMsgAttention
	 */
	public void save(UcMsgAttention ucMsgAttention);
	
	/**
	 * 根据用户编号与读取标识查询数量
	 * @param userCode
	 * 		用户编号
	 * @param status
	 * 		读取标识
	 * @return 数量
	 */
	public int queryCount(String userCode,String status);
	
	/**
	 * 查询用户分页信息对象
	 * @param pageNum
	 * 		页码
	 * @param limit
	 * 		每页展示数量
	 * @param conditions
	 * 		查询条件
	 * @return 分页对象
	 */
	public Page<UcMsgAttention> queryPageByUserCode(int pageNum, int limit,QueryConditions conditions);
	
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
