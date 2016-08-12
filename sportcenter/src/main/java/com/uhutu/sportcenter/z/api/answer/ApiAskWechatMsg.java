package com.uhutu.sportcenter.z.api.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.answer.z.support.AnswerMsgSupport;
import com.uhutu.dcom.pay.z.response.WechatMsgResponse;
import com.uhutu.sportcenter.z.input.ApiAskWechatMsgInput;
import com.uhutu.sportcenter.z.result.ApiAskWechatMsgResult;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 问题提问微信消息发送
 * @author 逄小帅
 *
 */
@Component
public class ApiAskWechatMsg extends RootApiToken<ApiAskWechatMsgInput, ApiAskWechatMsgResult> {
	
	@Autowired
	private AnswerServiceFactory answerServiceFactory;
	
	@Autowired
	private AnswerMsgSupport answerMsgSupport;

	@Override
	protected ApiAskWechatMsgResult process(ApiAskWechatMsgInput input) {
		
		ApiAskWechatMsgResult wechatMsgResult = new ApiAskWechatMsgResult();
		
		AwQuestionInfo qtInfo = answerServiceFactory.getQuestionInfoService().queryByCode(input.getQuestionCode());

		if(qtInfo != null){
			
			String requestUrl = input.getRequestUrl()+"/webjars/answer/audio.html?id="+input.getQuestionCode();
			
			requestUrl = TopHelper.upInfo(81110010, requestUrl);
			
			WechatMsgResponse wechatMsgResponse = answerMsgSupport.sendAskMsg(qtInfo, requestUrl);
			
			if (wechatMsgResponse != null && !wechatMsgResponse.upFlag()) {
				
				wechatMsgResult.setStatus(0);
				
				wechatMsgResult.setError(wechatMsgResponse.getErrmsg());
				
			}
			
		}else{
			
			wechatMsgResult.setStatus(0);
			
			wechatMsgResult.inError(88880008);
			
		}

		return wechatMsgResult;
	}
	

	


}
