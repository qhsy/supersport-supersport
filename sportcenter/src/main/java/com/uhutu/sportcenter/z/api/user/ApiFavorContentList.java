package com.uhutu.sportcenter.z.api.user;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnSupportPraise;
import com.uhutu.dcom.content.z.enums.ContentEnum;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.tag.z.service.ContentLabelServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.input.ApiFavorContentListInput;
import com.uhutu.sportcenter.z.result.ApiFavorContentListResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 喜欢内容列表
 * @author 逄小帅
 *
 */
@Component
public class ApiFavorContentList extends RootApiBase<ApiFavorContentListInput, ApiFavorContentListResult> {
	
	@Autowired
	private ContentServiceFactory contentServiceFactory;
	
	@Autowired
	private UserServiceFactory userServiceFactory;
	
	@Autowired
	private ContentLabelServiceFactory labelServiceFactory;

	@Override
	protected ApiFavorContentListResult process(ApiFavorContentListInput input) {
		
		ApiFavorContentListResult result = new ApiFavorContentListResult();

		QueryConditions conditions = new QueryConditions();

		conditions.setConditionEqual("userCode", input.getUserCode());

		conditions.setConditionEqual("status", ContentEnum.FAVOR_STATUS_YES.getCode());
		
		conditions.setConditionEqual("type", ContentEnum.FAVOR_TYPE_LIKE.getCode());

		Page<CnSupportPraise> praisePage = contentServiceFactory.getSupportPraiseService()
				.queryPageByCondition(input.getPagination(), 10, conditions);
		
		if(praisePage.hasNext()){
			
			result.setNextPageFlag(true);
			
		}else{
			
			result.setNextPageFlag(false);
			
		}
		
		if(praisePage.hasContent()){
			
			praisePage.getContent().forEach(praise -> {
				
				ContentBasicinfoForApi basicinfoForApi = new ContentBasicinfoForApi();
				
				CnContentBasicinfo basicinfo = contentServiceFactory.getContentBasicinfoService().queryByCode(praise.getContentCode());
				
				if(basicinfo != null){
					
					BeanUtils.copyProperties(basicinfo, basicinfoForApi);
					
					UcUserinfoExt userinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(basicinfo.getAuthor());
					
					if(userinfoExt != null){
						
						basicinfoForApi.setNickName(userinfoExt.getNickName());
						
						basicinfoForApi.setAboutHead(userinfoExt.getAboutHead());
						
						
					}					
					
					String tagName = labelServiceFactory.getContentLabelService().initTagName(basicinfoForApi.getTagCode());
					
					basicinfoForApi.setTagName(tagName);
					
					basicinfoForApi.setPublishTimeStr("MM-dd HH:mm");
					
					result.getContentInfoList().add(basicinfoForApi);
					
				}				
				
			});
			
		}

		return result;
	}

}
