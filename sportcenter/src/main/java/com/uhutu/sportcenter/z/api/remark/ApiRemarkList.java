package com.uhutu.sportcenter.z.api.remark;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.remark.z.entity.CnContentRemark;
import com.uhutu.dcom.remark.z.enums.RemarkEnum;
import com.uhutu.dcom.remark.z.service.ContentRemarkServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.ContentRemarkInfo;
import com.uhutu.sportcenter.z.entity.ContentReplyInfo;
import com.uhutu.sportcenter.z.input.ApiRemarkListInput;
import com.uhutu.sportcenter.z.result.ApiRemarkListResult;
import com.uhutu.zoocom.root.RootApiBase;
/**
 * 评论信息列表
 * @author 逄小帅
 *
 */
@Component
public class ApiRemarkList extends RootApiBase<ApiRemarkListInput, ApiRemarkListResult> {
	
	@Autowired
	private ContentRemarkServiceFactory serviceFactory;
	
	@Autowired
	private UserServiceFactory userSerivceFactory;

	@Override
	protected ApiRemarkListResult process(ApiRemarkListInput input) {
		
		ApiRemarkListResult remarkListResult = new ApiRemarkListResult();
		
		QueryConditions conditions = new QueryConditions();
		
		conditions.setConditionEqual("contentCode", input.getContentCode());
		
		conditions.setConditionEqual("status", RemarkEnum.FLAG_ENABLE.getCode());
		
		Page<CnContentRemark> remarkPage = serviceFactory.getContentRemarkService().queryPage(input.getPagination(), 10, conditions);
		
		if(remarkPage.hasNext()){
			
			remarkListResult.setNextflag(true);
			
		}
		
		remarkListResult.setTotal(remarkPage.getTotalElements());
		
		List<ContentReplyInfo> remarkInfos = new ArrayList<ContentReplyInfo>();		
		
		remarkPage.getContent().forEach(remark -> {
			
			ContentReplyInfo replyInfo = new ContentReplyInfo();
			
			CnContentRemark sourceRef = serviceFactory.getContentRemarkService().queryByCode(remark.getParentCode());
			
			replyInfo.setRefReplyInfo(initRemarkInfo(sourceRef));
			
			replyInfo.setReplyInfo(initRemarkInfo(remark));
			
			remarkInfos.add(replyInfo);
			
		});
		
		remarkListResult.setContentRemarkInfo(remarkInfos);
		
		return remarkListResult;
		
	}
	
	public ContentRemarkInfo initRemarkInfo(CnContentRemark remark){
		
		ContentRemarkInfo remarkInfo = null;
		
		if(remark != null){
			
			remarkInfo = new ContentRemarkInfo();
			
			BeanUtils.copyProperties(remark, remarkInfo);
			
			UcUserinfoExt ucUserinfoExt = userSerivceFactory.getUserInfoExtService().queryByUserCode(remark.getAuthor());
			
			UcUserinfo ucUserinfo = userSerivceFactory.getUserInfoService().queryByCode(remark.getAuthor());
			
			if(ucUserinfoExt != null && ucUserinfo != null){
				
				remarkInfo.setNickName(ucUserinfoExt.getNickName());
				
				remarkInfo.setAboutHead(ucUserinfoExt.getThumbUrl());
				
				remarkInfo.setType(ucUserinfo.getType());
				
			}
			
			String publishDate = DateFormatUtils.format(remark.getZc(), "yyyy-MM-dd HH:mm:ss");
			
			remarkInfo.setPublishTime(publishDate);
			
		}		
		
		return remarkInfo;
		
	}

}
