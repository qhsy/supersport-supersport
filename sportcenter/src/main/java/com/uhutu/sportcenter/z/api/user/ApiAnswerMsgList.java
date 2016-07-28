package com.uhutu.sportcenter.z.api.user;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.entity.UcMsgAnswer;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.MsgNoticeInfo;
import com.uhutu.sportcenter.z.input.ApiAnswerMsgListInput;
import com.uhutu.sportcenter.z.result.ApiAnswerMsgListResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 消息通知列表
 * @author 逄小帅
 *
 */
@Component
public class ApiAnswerMsgList extends RootApiToken<ApiAnswerMsgListInput, ApiAnswerMsgListResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiAnswerMsgListResult process(ApiAnswerMsgListInput input) {
		
		ApiAnswerMsgListResult result = new ApiAnswerMsgListResult();
		
		QueryConditions conditions = new QueryConditions();
		
		conditions.setConditionEqual("userCode", upUserCode());
		
		Page<UcMsgAnswer> settleAccountPage = userServiceFactory.getMsgAnswerService().queryPageByUserCode(input.getPagination(), 10, conditions);
		
		settleAccountPage.getContent().forEach( msgNotice -> {
			
			MsgNoticeInfo msgNoticeInfo = new MsgNoticeInfo();
			
			msgNoticeInfo.setContent(msgNotice.getContent());
			
			String msgTimeStr = DateFormatUtils.format(msgNotice.getZc(), "yyyy-MM-dd HH:mm:ss");
			
			msgNoticeInfo.setNotifyTime(msgTimeStr);			
			
			result.getMsgNoticeInfos().add(msgNoticeInfo);
			
		});
		
		return result;		
		
	}
	
	
}
