package com.uhutu.sportcenter.z.api.remark;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.remark.z.entity.CnContentRemark;
import com.uhutu.dcom.remark.z.service.ContentRemarkServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.api.util.ContentComponent;
import com.uhutu.sportcenter.z.entity.ContentRemarkInfo;
import com.uhutu.sportcenter.z.entity.ContentReplyInfo;
import com.uhutu.sportcenter.z.input.ApiRemarkListInput;
import com.uhutu.sportcenter.z.result.ApiRemarkListResult;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;
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
	private ContentServiceFactory contentServiceFactory;
	
	@Autowired
	private UserServiceFactory userSerivceFactory;

	@Override
	protected ApiRemarkListResult process(ApiRemarkListInput input) {
		
		ApiRemarkListResult remarkListResult = new ApiRemarkListResult();
		
		PageInfo pageInfo = new PageInfo(0, input.getPagination(), 10);
		
		List<CnContentRemark> remarkPage = serviceFactory.getContentRemarkService().queryPage(input.getContentCode(), pageInfo);
		
		remarkListResult.setTotal(pageInfo.getTotal());
		
		List<ContentReplyInfo> remarkInfos = new ArrayList<ContentReplyInfo>();		
		
		remarkPage.forEach(remark -> {
			
			ContentReplyInfo replyInfo = new ContentReplyInfo();
			
			CnContentRemark sourceRef = serviceFactory.getContentRemarkService().queryByCode(remark.getParentCode());
			
			CnContentBasicinfo contentBasicinfo = JdbcHelper.queryOne(CnContentBasicinfo.class, "code",remark.getContentCode());
			
			if(contentBasicinfo != null){
				
				replyInfo.setContentType(contentBasicinfo.getContentType());
				
			}
			
			ContentRemarkInfo refReplyInfo = initRemarkInfo(sourceRef,input.getZoo().getToken());
			
			ContentRemarkInfo subReplyInfo = initRemarkInfo(remark,input.getZoo().getToken());
			
			replyInfo.setRefReplyInfo(refReplyInfo);
			
			replyInfo.setReplyInfo(subReplyInfo);
			
			if(refReplyInfo == null){
				
				if(subReplyInfo != null && StringUtils.isNotEmpty(subReplyInfo.getParentCode())){
					
					replyInfo.setParentFlag(true);
					
				}
				
			}
			
			remarkInfos.add(replyInfo);
			
		});
		
		remarkListResult.setContentRemarkInfo(remarkInfos);
		
		return remarkListResult;
		
	}
	
	public ContentRemarkInfo initRemarkInfo(CnContentRemark remark,String token){
		
		ContentRemarkInfo remarkInfo = null;
		
		if(remark != null){
			
			remarkInfo = new ContentRemarkInfo();
			
			BeanUtils.copyProperties(remark, remarkInfo);
			
			UcUserinfoExt ucUserinfoExt = userSerivceFactory.getUserInfoExtService().queryByUserCode(remark.getAuthor());
			
			UcUserinfo ucUserinfo = userSerivceFactory.getUserInfoService().queryByCode(remark.getAuthor());
			
			if(ucUserinfoExt != null && ucUserinfo != null){
				
				remarkInfo.setNickName(ucUserinfoExt.getNickName());
				
				remarkInfo.setAboutHead(ucUserinfoExt.getAboutHead());
				
				remarkInfo.setType(ucUserinfo.getType());
				
			}
			
			String publishDate = DateFormatUtils.format(remark.getZc(), "yyyy-MM-dd HH:mm:ss");
			
			remarkInfo.setPublishTime(publishDate);
			
			int total = contentServiceFactory.getSupportPraiseService().queryCountByCode(remarkInfo.getCode(),ContentEnum.FAVOR_STATUS_YES.getCode());
			
			boolean praiseFlag = false;
			
			if(StringUtils.isNotBlank(token)){
				
				praiseFlag = ContentComponent.lightFavor(remarkInfo.getCode(), token);
				
			}
			
			remarkInfo.setPraiseFlag(praiseFlag);
			
			remarkInfo.setPraiseNum(total);
			
			String remarkContent = "";
			
			if(StringUtils.isNotBlank(remarkInfo.getRemark())){
				
				remarkContent = EmojiUtil.emojiRecovery(remarkInfo.getRemark());
				
			}
			
			remarkInfo.setRemark(remarkContent);
			
		}		
		
		return remarkInfo;
		
	}


}
