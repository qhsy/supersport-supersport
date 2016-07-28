package com.uhutu.dcom.user.z.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.entity.UcMsgNoticeUser;

/**
 * 消息通知用户service
 * @author 逄小帅
 *
 */
public interface IMsgAnswerService {
	
	/**
	 * 保存通知用户关联列表
	 * @param msgNoticeUsers
	 */
	public void save(List<UcMsgNoticeUser> msgNoticeUsers);
	
	/**
	 * 根据用户编号查询记录数量
	 * @param userCode
	 * 		用户编号
	 * @param status
	 * 		读取标识
	 * @return 未读记录数量
	 */
	public int queryCount(String userCode,String status);
	
	/**
	 * 
	 * @param pageNum
	 * 		页码
	 * @param limit
	 * 		每页展示数量
	 * @param conditions
	 * 		查询条件
	 * @return 查询分页信息
	 */
	public Page<UcMsgNoticeUser> queryPageByUserCode(int pageNum, int limit,QueryConditions conditions);
	
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
