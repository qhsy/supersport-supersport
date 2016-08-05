package com.uhutu.sportcenter.z.api.answer;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.sportcenter.z.input.ApiUpdateUserTitleInput;
import com.uhutu.sportcenter.z.result.ApiUpdateUserTitleResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 更新用户title
 * @author 逄小帅
 *
 */
@Component
public class ApiUpdateUserTitle extends RootApiToken<ApiUpdateUserTitleInput, ApiUpdateUserTitleResult> {

	@Override
	protected ApiUpdateUserTitleResult process(ApiUpdateUserTitleInput input) {
		
		ApiUpdateUserTitleResult result = new ApiUpdateUserTitleResult();
		
		if(StringUtils.isNotEmpty(input.getTitle())){
			
			AwAnswerExpert answerExpert = JdbcHelper.queryOne(AwAnswerExpert.class, "userCode",upUserCode());
			
			if(answerExpert != null ){
				
				answerExpert.setTitle(input.getTitle());
				
				JdbcHelper.update(answerExpert, "title", "userCode");
				
			}else{
				
				answerExpert = new AwAnswerExpert();
				
				answerExpert.setUserCode(upUserCode());
				
				answerExpert.setTitle(input.getTitle());
				
				answerExpert.setStatus(SystemEnum.NO.getCode());
				
				JdbcHelper.insert(answerExpert);
				
			}
			
		}
		
		return result;
	}

}
