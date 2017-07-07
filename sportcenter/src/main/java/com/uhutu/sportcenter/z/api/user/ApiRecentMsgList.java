package com.uhutu.sportcenter.z.api.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.user.z.entity.UcMsgAnswer;
import com.uhutu.dcom.user.z.entity.UcMsgFocus;
import com.uhutu.dcom.user.z.entity.UcMsgNotice;
import com.uhutu.dcom.user.z.entity.UcMsgNoticeUser;
import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.ApiMsgNoticeInfo;
import com.uhutu.sportcenter.z.entity.MsgNoticeInfo;
import com.uhutu.sportcenter.z.entity.MsgNumInfo;
import com.uhutu.sportcenter.z.input.ApiRecentMsgListInput;
import com.uhutu.sportcenter.z.result.ApiRecentMsgListResult;
import com.uhutu.zoocom.helper.DateHelper;
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
		
		saveMsgNotice(upUserCode());

		int noticeCount = JdbcHelper.count(UcMsgNoticeUser.class, "", MapHelper.initMap("userCode",upUserCode(),"status",MsgEnum.FLAG_UNREAD.getCode()));
		
		if(noticeCount > 0){
			
			updateMsgFocus(upUserCode(), MsgEnum.TYPE_SYSTEM.getCode());
			
		}
		
		UcMsgFocus msgFocus = userServiceFactory.getMsgFoucService().query(upUserCode(), MsgEnum.TYPE_SYSTEM.getCode());
		
		String flag = (msgFocus == null) ?"":msgFocus.getStatus();
		
		if(!StringUtils.equals(flag, MsgEnum.FLAG_READ.getCode()) ){
			
//			UcMsgNoticeUser ucMsgNoticeUser = JdbcHelper.queryOne(UcMsgNoticeUser.class, "", "-zc", "", MapHelper.initMap("userCode",upUserCode(),"status",MsgEnum.FLAG_UNREAD.getCode()));
			UcMsgNoticeUser ucMsgNoticeUser = JdbcHelper.queryOne(UcMsgNoticeUser.class, "", "-zc", "", MapHelper.initMap("userCode",upUserCode()));
			
			if(ucMsgNoticeUser != null){
				
				UcMsgNotice ucMsgNotice = JdbcHelper.queryOne(UcMsgNotice.class, "code",ucMsgNoticeUser.getNoticeCode());
				
				if(ucMsgNotice != null){
					
					ApiMsgNoticeInfo apiMsgNoticeInfo = new ApiMsgNoticeInfo();
					
					MsgNoticeInfo msgNoticeInfo = new MsgNoticeInfo();
					
					msgNoticeInfo.setContent(ucMsgNotice.getContent());
					
					msgNoticeInfo.setNotifyTime(DateHelper.parseDate(ucMsgNotice.getNotifyTime()));
					
					String content =  StringUtils.isEmpty(ucMsgNotice.getContent()) ? "" : EmojiUtil.emojiRecovery(ucMsgNotice.getContent());
					
					msgNoticeInfo.setContent(content);
					
					msgNoticeInfo.setBusiCode(ucMsgNotice.getCode());
					
					apiMsgNoticeInfo.setTitle("果冻体育");
					
					apiMsgNoticeInfo.setUnReadNum(userServiceFactory.getMsgNoticeUserService().queryCount(upUserCode(), MsgEnum.FLAG_UNREAD.getCode()));
					
					apiMsgNoticeInfo.setIconUrl("");
					
					apiMsgNoticeInfo.setMsgNoticeInfo(msgNoticeInfo);
					
					recentMsgListResult.setSytemMsgInfo(apiMsgNoticeInfo);
					
				}
				
			}
			
		}
		
		int answerCount = JdbcHelper.count(UcMsgAnswer.class, "", MapHelper.initMap("userCode",upUserCode(),"status",MsgEnum.FLAG_UNREAD.getCode()));
		
		if(answerCount > 0){
			
			updateMsgFocus(upUserCode(), MsgEnum.TYPE_ANSWER.getCode());
			
		}
		
		UcMsgFocus msgFocusAnswer = userServiceFactory.getMsgFoucService().query(upUserCode(), MsgEnum.TYPE_ANSWER.getCode());
		
		String answerFlag = (msgFocusAnswer == null) ?"":msgFocusAnswer.getStatus();
		
		if(!StringUtils.equals(answerFlag, MsgEnum.FLAG_READ.getCode())){
			
			UcMsgAnswer ucMsgAnswer = JdbcHelper.queryOne(UcMsgAnswer.class, "", "-zc", "", MapHelper.initMap("userCode",upUserCode()));
			
			if(ucMsgAnswer != null){
				
				ApiMsgNoticeInfo apiMsgNoticeInfo = new ApiMsgNoticeInfo();
				
				MsgNoticeInfo msgNoticeInfo = new MsgNoticeInfo();
				
				msgNoticeInfo.setContent(ucMsgAnswer.getContent());
				
				msgNoticeInfo.setNotifyTime(DateHelper.parseDate(ucMsgAnswer.getNotifyTime()));
				
				msgNoticeInfo.setBusiCode(ucMsgAnswer.getBusiCode());
				
				apiMsgNoticeInfo.setTitle("问达助手");
				
				apiMsgNoticeInfo.setUnReadNum(userServiceFactory.getMsgAnswerService().queryCount(upUserCode(), MsgEnum.FLAG_UNREAD.getCode()));
				
				apiMsgNoticeInfo.setIconUrl("");
				
				apiMsgNoticeInfo.setMsgNoticeInfo(msgNoticeInfo);
				
				recentMsgListResult.setAnswerMsgInfo(apiMsgNoticeInfo);
				
			}
			
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
	
	public void updateMsgFocus(String userCode, String msgType){
		
		UcMsgFocus msgFocus = new UcMsgFocus();
		
		msgFocus.setMsgType(msgType);
		
		msgFocus.setStatus(MsgEnum.FLAG_UNREAD.getCode());
		
		msgFocus.setUserCode(userCode);
		
		userServiceFactory.getMsgFoucService().save(msgFocus);
		
		
	}
	
	public void saveMsgNotice(String userCode){
		
		List<UcMsgNotice> msgNotices = userServiceFactory.getMsgNoticeService().queryUnReadMsgList(userCode);
		
		List<UcMsgNoticeUser> msgNoticeUsers = new ArrayList<UcMsgNoticeUser>();
		
		if(msgNotices != null){
			
			msgNotices.forEach(msgNotice ->{
				
				UcMsgNoticeUser ucMsgNoticeUser = new UcMsgNoticeUser();
				
				ucMsgNoticeUser.setNoticeCode(msgNotice.getCode());
				
				ucMsgNoticeUser.setUserCode(userCode);
				
				ucMsgNoticeUser.setStatus(MsgEnum.FLAG_UNREAD.getCode());
				
				ucMsgNoticeUser.setZc(new Date());
				
				msgNoticeUsers.add(ucMsgNoticeUser);
				
			});
			
			userServiceFactory.getMsgNoticeUserService().save(msgNoticeUsers);
			
		}
		
	}

}
