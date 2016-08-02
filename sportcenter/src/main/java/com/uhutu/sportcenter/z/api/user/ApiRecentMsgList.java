package com.uhutu.sportcenter.z.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.user.z.entity.UcMsgAnswer;
import com.uhutu.dcom.user.z.entity.UcMsgNotice;
import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.ApiMsgNoticeInfo;
import com.uhutu.sportcenter.z.entity.MsgNoticeInfo;
import com.uhutu.sportcenter.z.entity.MsgNumInfo;
import com.uhutu.sportcenter.z.input.ApiRecentMsgListInput;
import com.uhutu.sportcenter.z.result.ApiRecentMsgListResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 最近的消息列表
 * @author 逄小帅
 *
 */
@Component
public class ApiRecentMsgList extends RootApiToken<ApiRecentMsgListInput, ApiRecentMsgListResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiRecentMsgListResult process(ApiRecentMsgListInput input) {
		
		ApiRecentMsgListResult recentMsgListResult = new ApiRecentMsgListResult();
		
		UcMsgNotice ucMsgNotice = JdbcHelper.queryOne(UcMsgNotice.class, "", "-zc", "", MapHelper.initMap("status",MsgEnum.FLAG_UNREAD.getCode()));
		
		if(ucMsgNotice != null){
			
			ApiMsgNoticeInfo apiMsgNoticeInfo = new ApiMsgNoticeInfo();
			
			MsgNoticeInfo msgNoticeInfo = new MsgNoticeInfo();
			
			msgNoticeInfo.setContent(ucMsgNotice.getContent());
			
			msgNoticeInfo.setNotifyTime(ucMsgNotice.getNotifyTime());
			
			apiMsgNoticeInfo.setTitle("果冻体育");
			
			apiMsgNoticeInfo.setUnReadNum(userServiceFactory.getMsgNoticeUserService().queryCount(upUserCode(), MsgEnum.FLAG_UNREAD.getCode()));
			
			apiMsgNoticeInfo.setIconUrl("");
			
			apiMsgNoticeInfo.setMsgNoticeInfo(msgNoticeInfo);
			
			recentMsgListResult.setSytemMsgInfo(apiMsgNoticeInfo);
			
		}
		
		UcMsgAnswer ucMsgAnswer = JdbcHelper.queryOne(UcMsgAnswer.class, "", "-zc", "", MapHelper.initMap("userCode",upUserCode(),"status",MsgEnum.FLAG_UNREAD.getCode()));
		
		if(ucMsgAnswer != null){
			
			ApiMsgNoticeInfo apiMsgNoticeInfo = new ApiMsgNoticeInfo();
			
			MsgNoticeInfo msgNoticeInfo = new MsgNoticeInfo();
			
			msgNoticeInfo.setContent(ucMsgAnswer.getContent());
			
			msgNoticeInfo.setNotifyTime(ucMsgAnswer.getNotifyTime());
			
			apiMsgNoticeInfo.setTitle("问答助手");
			
			apiMsgNoticeInfo.setUnReadNum(userServiceFactory.getMsgNoticeUserService().queryCount(upUserCode(), MsgEnum.FLAG_UNREAD.getCode()));
			
			apiMsgNoticeInfo.setIconUrl("");
			
			apiMsgNoticeInfo.setMsgNoticeInfo(msgNoticeInfo);
			
			recentMsgListResult.setAnswerMsgInfo(apiMsgNoticeInfo);
			
		}
		
		String[] msgTypes = {MsgEnum.ATTEND.getCode(), MsgEnum.PRAISE.getCode(),
				MsgEnum.REMARK.getCode() };
		
		for (String msgType : msgTypes) {
			
			recentMsgListResult.getMsgNumInfos().add(initMsgNumInfo(upUserCode(), msgType));
			
		}
		
		return recentMsgListResult;
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
