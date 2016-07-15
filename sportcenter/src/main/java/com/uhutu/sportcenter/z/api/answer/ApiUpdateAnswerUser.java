package com.uhutu.sportcenter.z.api.answer;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.sportcenter.z.input.ApiUpdateAnswerUserInput;
import com.uhutu.sportcenter.z.result.ApiUpdateAnswerUserResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

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
		
		expert.setStatus(SystemEnum.YES.getCode());
		
		int status = answerServiceFactory.getAwAnswerExpertService().save(expert);
		
		UcUserinfoExt userinfoExt = JdbcHelper.queryOne(UcUserinfoExt.class, "userCode",upUserCode());
		
		if(userinfoExt != null){
			
			String swhere = "nickName = '" + userinfoExt.getNickName() + "'";
			
			swhere = " and userCode <>'"+upUserCode()+"'";
			
			int count = JdbcHelper.count(UcUserinfoExt.class, swhere, new MDataMap());
			
			if(count >= 1){
				
				result.inError(81100001);
				
			}else{
				
				userinfoExt.setNickName(input.getNickName());
				
				JdbcHelper.update(userinfoExt, "nickName", "userCode");
				
			}
			
		}
		
		if(status <= 0){
			
			result.inError(88880006);
			
		}
		
		return result;
	}

}
