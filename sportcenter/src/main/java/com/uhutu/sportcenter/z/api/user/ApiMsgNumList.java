package com.uhutu.sportcenter.z.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.MsgNumInfo;
import com.uhutu.sportcenter.z.input.ApiMsgNumListInput;
import com.uhutu.sportcenter.z.result.ApiMsgNumListResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 消息中心数量列表
 * @author 逄小帅
 *
 */
@Component
public class ApiMsgNumList extends RootApiToken<ApiMsgNumListInput, ApiMsgNumListResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiMsgNumListResult process(ApiMsgNumListInput input) {

		ApiMsgNumListResult msgNumListResult = new ApiMsgNumListResult();

		String userCode = upUserCode();

		String[] msgTypes = { MsgEnum.NOTICE.getCode(), MsgEnum.ATTEND.getCode(), MsgEnum.PRAISE.getCode(),
				MsgEnum.REMARK.getCode() };
		
		for (String msgType : msgTypes) {
			
			msgNumListResult.getMsgNumInfos().add(initMsgNumInfo(userCode, msgType));
			
		}

		return msgNumListResult;
	}
	
	public MsgNumInfo initMsgNumInfo(String userCode,String msgType){
		
		MsgNumInfo msgNumInfo = new MsgNumInfo();
		
		msgNumInfo.setMsgType(msgType);
		
		switch (msgType) {
		case "01":
			
			msgNumInfo.setTotal(userServiceFactory.getMsgAttentionService().queryCount(userCode, MsgEnum.FLAG_UNREAD.getCode()));
			
			break;
		
		case "02":
			
			msgNumInfo.setTotal(userServiceFactory.getMsgRemarkService().queryCount(userCode, MsgEnum.FLAG_UNREAD.getCode()));
			
			break;
			
		case "03":
			
			msgNumInfo.setTotal(userServiceFactory.getMsgNoticeUserService().queryCount(userCode, MsgEnum.FLAG_UNREAD.getCode()));
			
			break;
		
		case "04":
			
			msgNumInfo.setTotal(userServiceFactory.getMsgPraiseService().queryCount(userCode, MsgEnum.FLAG_UNREAD.getCode()));
			
			break;

		default:
			break;
		}
		
		return msgNumInfo;
		
	}
	

	

}
