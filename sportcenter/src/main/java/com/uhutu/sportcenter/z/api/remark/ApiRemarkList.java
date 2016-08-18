package com.uhutu.sportcenter.z.api.remark;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.content.z.entity.CnSupportPraise;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
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
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoocom.z.bean.TopUserFactory;
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
			
			replyInfo.setRefReplyInfo(initRemarkInfo(sourceRef,input.getZoo().getToken()));
			
			replyInfo.setReplyInfo(initRemarkInfo(remark,input.getZoo().getToken()));
			
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
			
			remarkInfo.setPraiseFlag(lightFavor(remarkInfo.getCode(), token));
			
			remarkInfo.setPraiseNum(total);
			
		}		
		
		return remarkInfo;
		
	}
	
	public boolean lightFavor(String contentCode,String token){
		
		boolean flag = false;
		
		String userCode = TopUserFactory.upUserCallFactory().upUserCodeByAuthToken(token, DefineUser.Login_System_Default);
		
		if(StringUtils.isNotBlank(userCode)){
			
			/*01点赞*/
			CnSupportPraise praise = contentServiceFactory.getSupportPraiseService().query(contentCode,userCode, "01");
			
			if(praise != null && StringUtils.equals(praise.getStatus(), ContentEnum.FAVOR_STATUS_YES.getCode())){
				
				flag = true;
				
			}
			
		}
		
		return flag;
		
	}


}
