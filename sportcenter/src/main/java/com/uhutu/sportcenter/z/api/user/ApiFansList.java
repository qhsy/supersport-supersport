package com.uhutu.sportcenter.z.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.enums.UserEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.ApiAttendInfo;
import com.uhutu.sportcenter.z.input.ApiFansListInput;
import com.uhutu.sportcenter.z.result.ApiFansListResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 粉丝列表
 * @author 逄小帅
 *
 */
@Component
public class ApiFansList extends RootApiBase<ApiFansListInput, ApiFansListResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiFansListResult process(ApiFansListInput input) {
		
		ApiFansListResult result = new ApiFansListResult();
		
		QueryConditions conditions = new QueryConditions();
		
		conditions.setConditionEqual("beAttention", input.getUserCode());
		
		conditions.setConditionEqual("status", UserEnum.ATTEND.getCode());
		
		Page<UcAttentionInfo> attendPage = userServiceFactory.getAttentionInfoService().queryPageByCondition(input.getPagination(), 10, conditions);
		
		if(attendPage.hasNext()){
			
			result.setNextPageFlag(true);
			
		}else{
			
			result.setNextPageFlag(false);
			
		}
		
		if(attendPage.hasContent()){
			
			attendPage.getContent().forEach(attendInfo ->{
				
				ApiAttendInfo apiAttendInfo = new ApiAttendInfo();
				
				apiAttendInfo.setUserCode(attendInfo.getBeAttention());
				
				UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(attendInfo.getAttention());
				
				UcUserinfo ucUserinfo = userServiceFactory.getUserInfoService().queryByCode(attendInfo.getAttention());
				
				if(ucUserinfoExt != null){
					
					apiAttendInfo.setAboutHead(ucUserinfoExt.getAboutHead());
					
					apiAttendInfo.setNickName(ucUserinfoExt.getNickName());
					
					apiAttendInfo.setUserCode(ucUserinfo.getCode());
					
					apiAttendInfo.setType(ucUserinfo.getType());
					
					result.getFansList().add(apiAttendInfo);
					
				}else{
					
					result.inError(81100003);
					
				}
				
			});
			
		}
		
		return result;
	}

}
