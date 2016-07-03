package com.uhutu.sportcenter.z.api.answer;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.sportcenter.z.input.ApiUpdateAnswerUserInput;
import com.uhutu.sportcenter.z.result.ApiUpdateAnswerUserResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 问答用户信息更新
 * @author 逄小帅
 *
 */
@Component
public class ApiUpdateAnswerUser extends RootApiToken<ApiUpdateAnswerUserInput, ApiUpdateAnswerUserResult> {
	
	@Autowired
	private AnswerServiceFactory answerServiceFactory;

	@Override
	protected ApiUpdateAnswerUserResult process(ApiUpdateAnswerUserInput input) {
		
		ApiUpdateAnswerUserResult result = new ApiUpdateAnswerUserResult();
		
		AwAnswerExpert expert = new AwAnswerExpert();
		
		BeanUtils.copyProperties(input, expert);
		
		expert.setUserCode(upUserCode());
		
		int status = answerServiceFactory.getAwAnswerExpertService().save(expert);
		
		if(status <= 0){
			
			result.inError(88880006);
			
		}
		
		return result;
	}

}
