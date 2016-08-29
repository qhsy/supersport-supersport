package com.uhutu.sportcenter.z.api.user;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.user.z.entity.UcMsgPraise;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.MsgPraiseInfo;
import com.uhutu.sportcenter.z.input.ApiMsgPraiseListInput;
import com.uhutu.sportcenter.z.result.ApiMsgPraiseListResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 点赞通知消息列表
 * @author 逄小帅
 *
 */
@Component
public class ApiMsgPraiseList extends RootApiToken<ApiMsgPraiseListInput, ApiMsgPraiseListResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;
	
	@Autowired
	private ContentServiceFactory contentServiceFactory;

	@Override
	protected ApiMsgPraiseListResult process(ApiMsgPraiseListInput input) {
		
		ApiMsgPraiseListResult msgPraiseListResult = new ApiMsgPraiseListResult();
		
		QueryConditions conditions = new QueryConditions();
		
		String userCode = upUserCode();
		
		conditions.setConditionEqual("contentAuthor", userCode);
		
		Page<UcMsgPraise> msgPraisePage = userServiceFactory.getMsgPraiseService().queryPageByUserCode(input.getPagination(), 10, conditions);
		
		msgPraisePage.getContent().forEach( msgPraise -> {
			
			CnContentBasicinfo basicinfo = contentServiceFactory.getContentBasicinfoService().queryByCode(msgPraise.getContentCode());
			
			MsgPraiseInfo msgPraiseInfo = new MsgPraiseInfo();
			
			msgPraiseInfo.setContentTitle(msgPraise.getContentTitle());
			
			msgPraiseInfo.setPraiseUserCode(msgPraise.getPraiseUserCode());
			
			if(basicinfo != null){
				
				msgPraiseInfo.setContentType(basicinfo.getContentType());
				
			}
			
			msgPraiseInfo.setContentCode(msgPraise.getContentCode());
			
			String msgTime = DateFormatUtils.format(msgPraise.getMsgTime(), "yyyy-MM-dd HH:mm:ss");
			
			msgPraiseInfo.setMsgTime(msgTime);
			
			UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(msgPraise.getPraiseUserCode());
			
			UcUserinfo ucUserinfo = userServiceFactory.getUserInfoService().queryByCode(msgPraise.getPraiseUserCode());
			
			if(ucUserinfoExt != null && ucUserinfo != null){
				
				msgPraiseInfo.setAboutHead(ucUserinfoExt.getAboutHead());
				
				msgPraiseInfo.setNickName(ucUserinfoExt.getNickName());
				
				msgPraiseInfo.setType(ucUserinfo.getType());
				
			}
			
			msgPraiseListResult.getMsgPraiseInfos().add(msgPraiseInfo);
			
			
		});
		
		if(msgPraisePage.hasNext()){
			
			msgPraiseListResult.setNextflag(true);
			
		}
		
		return msgPraiseListResult;
		
	}

}
