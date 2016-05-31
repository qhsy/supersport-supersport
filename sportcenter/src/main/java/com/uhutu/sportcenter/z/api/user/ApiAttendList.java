package com.uhutu.sportcenter.z.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.ApiAttendInfo;
import com.uhutu.sportcenter.z.input.ApiAttendListInput;
import com.uhutu.sportcenter.z.result.ApiAttendListResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 用户关注信息列表
 * @author 逄小帅
 *
 */
@Component
public class ApiAttendList extends RootApiBase<ApiAttendListInput, ApiAttendListResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiAttendListResult process(ApiAttendListInput input) {
		
		ApiAttendListResult result = new ApiAttendListResult();
		
		QueryConditions conditions = new QueryConditions();
		
		conditions.setConditionEqual("attention", input.getUserCode());
		
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
				
				UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(attendInfo.getBeAttention());
				
				if(ucUserinfoExt != null){
					
					apiAttendInfo.setHeadUrl(ucUserinfoExt.getAboutHead());
					
					apiAttendInfo.setNickName(ucUserinfoExt.getNickName());
					
					result.getAttendList().add(apiAttendInfo);
					
				}else{
					
					result.inError(81100003);
					
				}
				
			});
			
		}
		
		return result;
	}

}
