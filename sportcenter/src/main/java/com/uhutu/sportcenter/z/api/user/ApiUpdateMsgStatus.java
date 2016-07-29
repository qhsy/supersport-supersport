package com.uhutu.sportcenter.z.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiUpdateMsgStatusInput;
import com.uhutu.sportcenter.z.result.ApiUpdateMsgStatusResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 消息状态更新
 * @author 逄小帅
 *
 */
@Component
public class ApiUpdateMsgStatus extends RootApiToken<ApiUpdateMsgStatusInput, ApiUpdateMsgStatusResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;
	
	@Override
	protected ApiUpdateMsgStatusResult process(ApiUpdateMsgStatusInput input) {
		
		ApiUpdateMsgStatusResult apiUpdateMsgStatusResult = new ApiUpdateMsgStatusResult();
		
		switch (input.getMsgType()) {
		
		case "02":
			remarkStatus(upUserCode());
			break;
		
		case "04":
			praiseStatus(upUserCode());
			break;
			
		case "01":
			attendStatus(upUserCode());
			break;
			
		case "03":
			noticeStatus(upUserCode());
			break;
			
		case "05":
			answerStatus(upUserCode());
			break;

		default:
			break;
		}
		
		
		return apiUpdateMsgStatusResult;
		
	}
	
	/**
	 * 更新评论消息状态为已读
	 * @param userCode
	 */
	public void remarkStatus(String userCode){
		
		userServiceFactory.getMsgRemarkService().updateReadStatus(userCode, MsgEnum.FLAG_READ.getCode(), MsgEnum.FLAG_UNREAD.getCode());
		
	}
	
	/**
	 * 更新点赞消息状态为已读
	 * @param userCode
	 */
	public void praiseStatus(String userCode){
		
		userServiceFactory.getMsgPraiseService().updateReadStatus(userCode, MsgEnum.FLAG_READ.getCode(), MsgEnum.FLAG_UNREAD.getCode());
		
	}
	
	/**
	 * 关注消息状态
	 * @param userCode
	 */
	public void attendStatus(String userCode){
		
		userServiceFactory.getMsgAttentionService().updateReadStatus(userCode, MsgEnum.FLAG_READ.getCode(), MsgEnum.FLAG_UNREAD.getCode());
		
	}
	
	/**
	 * 通知消息状态
	 * @param userCode
	 */
	public void noticeStatus(String userCode){
		
		userServiceFactory.getMsgNoticeUserService().updateReadStatus(userCode, MsgEnum.FLAG_READ.getCode(), MsgEnum.FLAG_UNREAD.getCode());
		
	}
	
	/**
	 * 问答消息状态
	 * @param userCode
	 */
	public void answerStatus(String userCode){
		
		userServiceFactory.getMsgAnswerService().updateReadStatus(userCode, MsgEnum.FLAG_READ.getCode(), MsgEnum.FLAG_UNREAD.getCode());
		
	}

}
