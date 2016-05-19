package com.uhutu.sportcenter.z.api.user;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.remark.z.entity.CnContentRemark;
import com.uhutu.dcom.remark.z.service.ContentRemarkServiceFactory;
import com.uhutu.dcom.user.z.entity.UcMsgRemark;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.ContentRemarkInfo;
import com.uhutu.sportcenter.z.entity.ContentReplyInfo;
import com.uhutu.sportcenter.z.input.ApiMsgRemarkListInput;
import com.uhutu.sportcenter.z.result.ApiMsgRemarkResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 用户消息中心评论列表
 * @author 逄小帅
 *
 */
@Component
public class ApiMsgRemarkList extends RootApiToken<ApiMsgRemarkListInput, ApiMsgRemarkResult> {
	
	@Autowired
	private ContentRemarkServiceFactory serviceFactory;
	
	@Autowired
	private UserServiceFactory userSerivceFactory;


	@Override
	protected ApiMsgRemarkResult process(ApiMsgRemarkListInput input) {
		
		ApiMsgRemarkResult msgRemarkResult = new ApiMsgRemarkResult();
		
		String userCode = input.getZoo().getToken();
		
		QueryConditions conditions = new QueryConditions();
		
		conditions.setConditionEqual("contentAuthor", userCode);
		
		Page<UcMsgRemark> msgRemarkPage = userSerivceFactory.getMsgRemarkService()
				.queryPageByUserCode(input.getPagination(), 10, conditions);
		
		msgRemarkPage.getContent().forEach(msgRemark -> {
			
			ContentReplyInfo contentReplyInfo = new ContentReplyInfo();
			
			contentReplyInfo.setContentTitle(msgRemark.getContentTitle());
			
			CnContentRemark contentRemarkInfo = serviceFactory.getContentRemarkService().queryByCode(msgRemark.getRemarkCode());
		
			contentReplyInfo.setReplyInfo(initRemarkInfo(contentRemarkInfo));
			
			if(StringUtils.isNotBlank(msgRemark.getRemarkParentCode())){
				
				CnContentRemark parentRemarkInfo = serviceFactory.getContentRemarkService().queryByCode(msgRemark.getRemarkCode());
				
				contentReplyInfo.setRefReplyInfo(initRemarkInfo(parentRemarkInfo));
				
			}
			
			msgRemarkResult.getContentRemarkInfo().add(contentReplyInfo);
			
		});
		
		return msgRemarkResult;
		
	}
	
	public ContentRemarkInfo initRemarkInfo(CnContentRemark remark){
		
		ContentRemarkInfo remarkInfo = null;
		
		if(remark != null){
			
			remarkInfo = new ContentRemarkInfo();
			
			BeanUtils.copyProperties(remark, remarkInfo);
			
			UcUserinfoExt ucUserinfoExt = userSerivceFactory.getUserInfoExtService().queryByUserCode(remark.getAuthor());
			
			if(ucUserinfoExt != null){
				
				remarkInfo.setAuthorName(ucUserinfoExt.getNickName());
				
				remarkInfo.setHeadUrl(ucUserinfoExt.getAboutHead());
				
			}
			
			String publishDate = DateFormatUtils.format(remark.getZc(), "yyyy-MM-dd HH:mm:ss");
			
			remarkInfo.setPublishTime(publishDate);
			
		}		
		
		return remarkInfo;
		
	}

}
