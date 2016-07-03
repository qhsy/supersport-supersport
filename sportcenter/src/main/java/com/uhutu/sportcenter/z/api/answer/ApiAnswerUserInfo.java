package com.uhutu.sportcenter.z.api.answer;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.AnswerUserInfo;
import com.uhutu.sportcenter.z.input.ApiAnswerUserInfoInput;
import com.uhutu.sportcenter.z.result.ApiAnswerUserInfoResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 问答用户信息
 * @author 逄小帅
 *
 */
@Component
public class ApiAnswerUserInfo extends RootApiToken<ApiAnswerUserInfoInput, ApiAnswerUserInfoResult> {

	@Autowired
	private AnswerServiceFactory answerServiceFactory;
	
	@Autowired
	private UserInfoSupport userInfoSupport;
	
	@Override
	protected ApiAnswerUserInfoResult process(ApiAnswerUserInfoInput input) {
		
		ApiAnswerUserInfoResult result = new ApiAnswerUserInfoResult();
		
		AwAnswerExpert expert = answerServiceFactory.getAwAnswerExpertService().getByUserCode(upUserCode());
		
		if(expert != null){
			
			AnswerUserInfo answerUserInfo = new AnswerUserInfo();
			
			BeanUtils.copyProperties(expert, answerUserInfo);
			
			UcUserinfoExt userInfoExt = userInfoSupport.getUserInfoExt(upUserCode());
			
			if(userInfoExt != null){
				
				answerUserInfo.setNickName(userInfoExt.getNickName());
				
				answerUserInfo.setAboutHead(userInfoExt.getAboutHead());
				
			}else{
				
				result.inError(88880005);
				
			}
			
			result.setAnswerUserInfo(answerUserInfo);
			
		}else{
			
			result.inError(88880004);
			
		}
		
		return result;
		
	}

}
