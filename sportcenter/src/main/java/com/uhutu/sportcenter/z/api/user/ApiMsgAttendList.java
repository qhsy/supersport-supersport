package com.uhutu.sportcenter.z.api.user;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.entity.UcMsgAttention;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.MsgAttendInfo;
import com.uhutu.sportcenter.z.input.ApiMsgAttendListInput;
import com.uhutu.sportcenter.z.result.ApiMsgAttendListResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 关注消息通知列表
 * @author 逄小帅
 *
 */
@Component
public class ApiMsgAttendList extends RootApiToken<ApiMsgAttendListInput, ApiMsgAttendListResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiMsgAttendListResult process(ApiMsgAttendListInput input) {
		
		ApiMsgAttendListResult attendListResult = new ApiMsgAttendListResult();
		
		String userCode = upUserCode();
		
		QueryConditions conditions = new QueryConditions();
		
		conditions.setConditionEqual("attnUserCode", userCode);
		
		Page<UcMsgAttention> msgAttendPage = userServiceFactory.getMsgAttentionService().queryPageByUserCode(input.getPagination(), 10, conditions);
		
		msgAttendPage.getContent().forEach(msgAttend -> {
			
			MsgAttendInfo msgAttendInfo = new MsgAttendInfo();
			
			msgAttendInfo.setFansUserCode(msgAttend.getFansUserCode());
			
			String msgTime = DateFormatUtils.format(msgAttend.getMsgTime(), "yyyy-MM-dd hh:mm:ss");
			
			msgAttendInfo.setMsgTime(msgTime);
			
			UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(msgAttend.getFansUserCode());
			
			UcUserinfo ucUserinfo = userServiceFactory.getUserInfoService().queryByCode(msgAttend.getFansUserCode());
			
			if(ucUserinfo != null && ucUserinfoExt != null){
				
				msgAttendInfo.setAboutHead(ucUserinfoExt.getAboutHead());
				
				msgAttendInfo.setNickName(ucUserinfoExt.getNickName());
				
				msgAttendInfo.setType(ucUserinfo.getType());
				
			}
			
			attendListResult.getMsgAttendInfos().add(msgAttendInfo);
			
			
		});
		
		if(msgAttendPage.hasNext()){
			
			attendListResult.setNextflag(true);
			
		}
		
		return attendListResult;
	}

}
