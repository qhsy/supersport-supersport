package com.uhutu.sportcenter.z.api.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.sportcenter.z.input.ApiAppUpdateAnswerUserInput;
import com.uhutu.sportcenter.z.result.ApiAppUpdateAnswerUserResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 问答用户信息更新
 * @author 逄小帅
 *
 */
@Component
public class ApiAppUpdateAnswerUser extends RootApiToken<ApiAppUpdateAnswerUserInput, ApiAppUpdateAnswerUserResult> {
	
	@Autowired
	private AnswerServiceFactory answerServiceFactory;

	@Override
	protected ApiAppUpdateAnswerUserResult process(ApiAppUpdateAnswerUserInput input) {
		
		ApiAppUpdateAnswerUserResult result = new ApiAppUpdateAnswerUserResult();
		
		AwAnswerExpert expert = JdbcHelper.queryOne(AwAnswerExpert.class, "userCode",upUserCode());
		
		if(expert == null){
			
			expert = new AwAnswerExpert();
			
		}
		
		expert.setAbility(input.getAbility());
		
		expert.setCharge(input.getCharge());
		
		expert.setUserCode(upUserCode());
		
		if(input.isOpenFlag()){
			
			expert.setStatus(SystemEnum.YES.getCode());
			
		}else{
			
			expert.setStatus(SystemEnum.NO.getCode());
			
		}
		
		int status = answerServiceFactory.getAwAnswerExpertService().save(expert);			
		
		if(status <= 0){
			
			result.inError(88880006);
			
		}
		
		return result;
	}

}
