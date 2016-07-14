package com.uhutu.sportcenter.z.api.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.answer.z.entity.AwAnswerListen;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.component.z.page.QueryConditions;
import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.enums.UserEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.ApiAnswerAttendInfo;
import com.uhutu.sportcenter.z.input.ApiAnswerAttendListInput;
import com.uhutu.sportcenter.z.result.ApiAnswerAttendListResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 用户关注信息列表
 * @author 逄小帅
 *
 */
@Component
public class ApiAnswerAttendList extends RootApiBase<ApiAnswerAttendListInput, ApiAnswerAttendListResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;
	
	@Autowired
	private AnswerServiceFactory answerServiceFactory;

	@Override
	protected ApiAnswerAttendListResult process(ApiAnswerAttendListInput input) {
		
		ApiAnswerAttendListResult result = new ApiAnswerAttendListResult();
		
		QueryConditions conditions = new QueryConditions();
		
		conditions.setConditionEqual("attention", input.getUserCode());
		
		conditions.setConditionEqual("status", UserEnum.ATTEND.getCode());
		
		Page<UcAttentionInfo> attendPage = userServiceFactory.getAttentionInfoService().queryPageByCondition(input.getPagination(), 10, conditions);
		
		if(attendPage.hasNext()){
			
			result.setNextPageFlag(true);
			
		}else{
			
			result.setNextPageFlag(false);
			
		}
		
		if(attendPage.hasContent()){
			
			attendPage.getContent().forEach(attendInfo ->{
				
				ApiAnswerAttendInfo apiAttendInfo = new ApiAnswerAttendInfo();
				
				apiAttendInfo.setUserCode(attendInfo.getBeAttention());
				
				UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(attendInfo.getBeAttention());
				
				UcUserinfo ucUserinfo = userServiceFactory.getUserInfoService().queryByCode(attendInfo.getBeAttention());
				
				if(ucUserinfoExt != null && ucUserinfo != null){
					
					apiAttendInfo.setAboutHead(ucUserinfoExt.getAboutHead());
					
					apiAttendInfo.setNickName(ucUserinfoExt.getNickName());
					
					apiAttendInfo.setType(ucUserinfo.getType());
					
					apiAttendInfo.setUserCode(ucUserinfo.getCode());
					
					AwAnswerExpert answerExpert = answerServiceFactory.getAwAnswerExpertService().getByUserCode(attendInfo.getBeAttention());
					
					if(answerExpert != null){
						
						apiAttendInfo.setTitle(answerExpert.getTitle());
						
						int total = JdbcHelper.count(AwAnswerListen.class, "", MapHelper.initMap("userCode",attendInfo.getBeAttention()));
						
						apiAttendInfo.setTotal(total);
						
					}
					
					result.getAttendList().add(apiAttendInfo);
					
				}else{
					
					result.inError(81100003);
					
				}
				
			});
			
		}
		
		return result;
	}

}
