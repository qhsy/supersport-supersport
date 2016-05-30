package com.uhutu.sportcenter.z.api.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.entity.UcMsgNotice;
import com.uhutu.dcom.user.z.entity.UcMsgNoticeUser;
import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.MsgNoticeInfo;
import com.uhutu.sportcenter.z.input.ApiMsgNoticeListInput;
import com.uhutu.sportcenter.z.result.ApiMsgNoticeListResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 消息通知列表
 * @author 逄小帅
 *
 */
@Component
public class ApiMsgNoticeList extends RootApiToken<ApiMsgNoticeListInput, ApiMsgNoticeListResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiMsgNoticeListResult process(ApiMsgNoticeListInput input) {
		
		ApiMsgNoticeListResult result = new ApiMsgNoticeListResult();
		
		String userCode = upUserCode();
		
		saveMsgNotice(userCode);
		
		QueryConditions conditions = new QueryConditions();
		
		conditions.setConditionEqual("userCode", userCode);
		
		Page<UcMsgNoticeUser> msgNoticeUserPage= userServiceFactory.getMsgNoticeUserService().queryPageByUserCode(input.getPagination(), 10, conditions);
		
		msgNoticeUserPage.getContent().forEach( msgNotice -> {
			
			MsgNoticeInfo msgNoticeInfo = new MsgNoticeInfo();
			
			UcMsgNotice ucMsgNotice = userServiceFactory.getMsgNoticeService().queryByCode(msgNotice.getNoticeCode());
			
			msgNoticeInfo.setContent(ucMsgNotice.getContent());
			
			String msgTimeStr = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
			
			msgNoticeInfo.setNotifyTime(msgTimeStr);			
			
			result.getMsgNoticeInfos().add(msgNoticeInfo);
			
		});
		
		return result;
	}
	
	public void saveMsgNotice(String userCode){
		
		List<UcMsgNotice> msgNotices = userServiceFactory.getMsgNoticeService().queryUnReadMsgList(userCode);
		
		List<UcMsgNoticeUser> msgNoticeUsers = new ArrayList<UcMsgNoticeUser>();
		
		if(msgNotices != null){
			
			msgNotices.forEach(msgNotice ->{
				
				UcMsgNoticeUser ucMsgNoticeUser = new UcMsgNoticeUser();
				
				ucMsgNoticeUser.setNoticeCode(msgNotice.getCode());
				
				ucMsgNoticeUser.setUserCode(userCode);
				
				ucMsgNoticeUser.setStatus(MsgEnum.FLAG_READ.getCode());
				
				ucMsgNoticeUser.setZc(new Date());
				
			});
			
			userServiceFactory.getMsgNoticeUserService().save(msgNoticeUsers);
			
		}
		
	}

}
