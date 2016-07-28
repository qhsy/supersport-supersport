package com.uhutu.sportcenter.z.api.user;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.user.z.entity.UcMsgAnswer;
import com.uhutu.dcom.user.z.entity.UcMsgNotice;
import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.ApiMsgNoticeInfo;
import com.uhutu.sportcenter.z.entity.MsgNoticeInfo;
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
			
			String msgTimeStr = DateFormatUtils.format(ucMsgNotice.getZc(), "yyyy-MM-dd HH:mm:ss");
			
			msgNoticeInfo.setNotifyTime(msgTimeStr);
			
			apiMsgNoticeInfo.setTitle("果冻体育");
			
			apiMsgNoticeInfo.setUnReadNum(userServiceFactory.getMsgNoticeUserService().queryCount(upUserCode(), MsgEnum.FLAG_UNREAD.getCode()));
			
			apiMsgNoticeInfo.setIconUrl("");
			
			apiMsgNoticeInfo.setMsgNoticeInfo(msgNoticeInfo);
			
			recentMsgListResult.setSytemMsgInfo(apiMsgNoticeInfo);
			
		}
		
		UcMsgAnswer ucMsgAnswer = JdbcHelper.queryOne(UcMsgAnswer.class, "", "-zc", "", MapHelper.initMap("status",MsgEnum.FLAG_UNREAD.getCode()));
		
		if(ucMsgAnswer != null){
			
			ApiMsgNoticeInfo apiMsgNoticeInfo = new ApiMsgNoticeInfo();
			
			MsgNoticeInfo msgNoticeInfo = new MsgNoticeInfo();
			
			msgNoticeInfo.setContent(ucMsgAnswer.getContent());
			
			String msgTimeStr = DateFormatUtils.format(ucMsgAnswer.getZc(), "yyyy-MM-dd HH:mm:ss");
			
			msgNoticeInfo.setNotifyTime(msgTimeStr);
			
			apiMsgNoticeInfo.setTitle("问答助手");
			
			apiMsgNoticeInfo.setUnReadNum(userServiceFactory.getMsgNoticeUserService().queryCount(upUserCode(), MsgEnum.FLAG_UNREAD.getCode()));
			
			apiMsgNoticeInfo.setIconUrl("");
			
			recentMsgListResult.setAnswerMsgInfo(apiMsgNoticeInfo);
			
		}
		
		return recentMsgListResult;
	}

}
