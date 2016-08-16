package com.uhutu.sportcenter.z.api.user;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.UserInfo;
import com.uhutu.sportcenter.z.input.ApiUpdateUserInfoInput;
import com.uhutu.sportcenter.z.result.ApiUpdateUserInfoResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 更新用户信息
 * @author 逄小帅
 *
 */
@Component
public class ApiUpdateUserInfo extends RootApiToken<ApiUpdateUserInfoInput, ApiUpdateUserInfoResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiUpdateUserInfoResult process(ApiUpdateUserInfoInput input) {
		
		ApiUpdateUserInfoResult result = new ApiUpdateUserInfoResult();
		
		Optional<UserInfo> userOption = Optional.ofNullable(input.getUserInfo());
		
		if(userOption.isPresent()){
			
			String userCode = upUserCode();
			
			UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(userCode);
			
			Optional<UcUserinfoExt> userInfoExtOptional = Optional.ofNullable(ucUserinfoExt);
			
			if(userInfoExtOptional.isPresent()){
				
				String headUrl = input.getUserInfo().getAboutHead();
				
				if(!StringUtils.equals(headUrl, ucUserinfoExt.getAboutHead())){
					
					headUrl = ImageHelper.upImageThumbnail(headUrl, 180);
					
				}
				
				BeanUtils.copyProperties(input.getUserInfo(), ucUserinfoExt);
				
				ucUserinfoExt.setAboutHead(headUrl);
				
				if(StringUtils.isNotBlank(ucUserinfoExt.getTitle())){
					
					updateAnswerTitle(userCode, ucUserinfoExt.getTitle());
					
				}
				
				userServiceFactory.getUserInfoExtService().save(ucUserinfoExt);
				
			}else{
				
				result.setStatus(0);
				
				result.setError("用户信息不存在");
				
			}
			
			
			
		}else{
			
			result.setStatus(0);
			
			result.setError("用户信息为空");
			
		}
		
		return result;
	}
	
	public void updateAnswerTitle(String userCode,String title){
		
		AwAnswerExpert answerExpert = new AwAnswerExpert();
		
		answerExpert.setUserCode(userCode);
		
		answerExpert.setTitle(title);
		
		JdbcHelper.update(answerExpert, "title", "userCode");
		
	}

}
