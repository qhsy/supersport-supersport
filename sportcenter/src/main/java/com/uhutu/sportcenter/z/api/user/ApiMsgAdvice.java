package com.uhutu.sportcenter.z.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.config.enums.PrexEnum;
import com.uhutu.dcom.user.z.entity.UcMsgAdvice;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiMsgAdviceInput;
import com.uhutu.sportcenter.z.result.ApiMsgAdviceResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zooweb.helper.WebHelper;

/**
 * 意见投诉
 * @author 逄小帅
 *
 */
@Component
public class ApiMsgAdvice extends RootApiToken<ApiMsgAdviceInput, ApiMsgAdviceResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiMsgAdviceResult process(ApiMsgAdviceInput input) {
		
		ApiMsgAdviceResult result = new ApiMsgAdviceResult();
		
		UcMsgAdvice ucMsgAdvice = new UcMsgAdvice();
		
		ucMsgAdvice.setCode(WebHelper.upCode(PrexEnum.UMA.name()));
		
		ucMsgAdvice.setContent(input.getContent());
		
		ucMsgAdvice.setUserCode(upUserCode());
		
		userServiceFactory.getMsgAdviceService().save(ucMsgAdvice);
		
		return result;
		
	}

}
