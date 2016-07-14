package com.uhutu.sportcenter.z.api.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.answer.z.common.AnswerEnum;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.request.WechatMsgAskRequest;
import com.uhutu.dcom.pay.z.response.WechatMsgResponse;
import com.uhutu.dcom.pay.z.util.WechatMsgComponent;
import com.uhutu.dcom.user.z.entity.UcUserinfoSocial;
import com.uhutu.dcom.user.z.entity.UserBasicInfo;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
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
	private UserInfoSupport userInfoSupport;
	
	@Autowired
	private WechatMsgComponent wechatMsgCompoent;
	
	@Autowired
	private AnswerServiceFactory answerServiceFactory;

	@Override
	protected ApiAskWechatMsgResult process(ApiAskWechatMsgInput input) {
		
		ApiAskWechatMsgResult wechatMsgResult = new ApiAskWechatMsgResult();
		
		AwQuestionInfo qtInfo = answerServiceFactory.getQuestionInfoService().queryByCode(input.getQuestionCode());

		if(qtInfo != null){
			
			String requestUrl = input.getRequestUrl()+"/webjars/answer/audio.html?id="+input.getQuestionCode();
			
			requestUrl = TopHelper.upInfo(81110010, requestUrl);
			
			WechatMsgResponse wechatMsgResponse = sendWechatMsg(qtInfo,requestUrl);
			
			if (!wechatMsgResponse.upFlag()) {
				
				wechatMsgResult.setStatus(0);
				
				wechatMsgResult.setError(wechatMsgResponse.getErrmsg());
				
			}
			
		}else{
			
			wechatMsgResult.setStatus(0);
			
			wechatMsgResult.inError(88880008);
			
		}

		return wechatMsgResult;
	}
	
	/**
	 * 发送微信消息
	 * 
	 * @param questionInfo
	 *            问题信息
	 * @return 信息响应
	 */
	public WechatMsgResponse sendWechatMsg(AwQuestionInfo questionInfo,String requestUrl) {

		WechatMsgAskRequest askRequest = new WechatMsgAskRequest();

		UserBasicInfo userBasicInfo = userInfoSupport.getUserBasicInfo(questionInfo.getQuestionUserCode());

		UcUserinfoSocial answerSocial = userInfoSupport.getUserInfoSocial(questionInfo.getAnswerUserCode());

		askRequest.getFirst().setValue(TopHelper.upInfo(88880015, userBasicInfo.getUcUserinfoExt().getNickName()));

		askRequest.getKeyword1().setValue(questionInfo.getContent());

		askRequest.getKeyword2().setValue(AnswerEnum.praseText(questionInfo.getScope()));

		askRequest.getKeyword3().setValue(questionInfo.getQuestionTime());

		askRequest.getRemark().setValue(TopHelper.upInfo(88880016, questionInfo.getMoney().setScale(2).toString()));

		return wechatMsgCompoent.sendMsg(answerSocial.getAccountId(), requestUrl, PayProcessEnum.WECHAT_MSG_ASK, askRequest);

	}

}