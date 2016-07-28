package com.uhutu.sportcenter.z.api.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.entity.AwSettleAccount;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.sportcenter.z.input.ApiBindSettleAccountInput;
import com.uhutu.sportcenter.z.result.ApiBindSettleAccountResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 绑定结算账户
 * @author 逄小帅
 *
 */
@Component
public class ApiBindSettleAccount extends RootApiToken<ApiBindSettleAccountInput, ApiBindSettleAccountResult> {
	
	@Autowired
	private AnswerServiceFactory answerServiceFactory;

	@Override
	protected ApiBindSettleAccountResult process(ApiBindSettleAccountInput input) {
		
		ApiBindSettleAccountResult result = new ApiBindSettleAccountResult();
		
		AwSettleAccount settleAccount = answerServiceFactory.getSettleAccountService().queryByUserCode(upUserCode());
		
		if(input.isBinding()){
			
			if(settleAccount == null){
				
				settleAccount = new AwSettleAccount();
				
			}
			
			settleAccount.setAppid(input.getAppid());
			
			settleAccount.setOpenid(input.getOpenid());
			
			settleAccount.setStatus(SystemEnum.YES.getCode());
			
			settleAccount.setType("wechat");
			
			settleAccount.setUnionid(input.getUnionid());
			
			settleAccount.setUserCode(upUserCode());
			
			answerServiceFactory.getSettleAccountService().save(settleAccount);
			
			
		}else{
			
			if(settleAccount == null){
				
				result.inError(88880024);
				
			}else{
				
				settleAccount.setStatus(SystemEnum.NO.getCode());
				
				answerServiceFactory.getSettleAccountService().save(settleAccount);
				
			}
			
		}
		
		return result;
	}

}
