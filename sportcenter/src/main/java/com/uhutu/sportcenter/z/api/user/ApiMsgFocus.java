package com.uhutu.sportcenter.z.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.user.z.entity.UcMsgFocus;
import com.uhutu.dcom.user.z.enums.MsgEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiMsgFocusInput;
import com.uhutu.sportcenter.z.result.ApiMsgFocusResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 消息关注状态
 * @author 逄小帅
 *
 */
@Component
public class ApiMsgFocus extends RootApiToken<ApiMsgFocusInput, ApiMsgFocusResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiMsgFocusResult process(ApiMsgFocusInput input) {
		
		ApiMsgFocusResult focusResult = new ApiMsgFocusResult();
		
		UcMsgFocus ucMsgFocus = new UcMsgFocus();
		
		ucMsgFocus.setUserCode(upUserCode());
		
		ucMsgFocus.setMsgType(input.getMsgType());
		
		ucMsgFocus.setStatus(MsgEnum.FLAG_READ.getCode());
		
		userServiceFactory.getMsgFoucService().save(ucMsgFocus);
		
		return focusResult;
	}

}
