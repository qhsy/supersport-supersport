package com.uhutu.sportcenter.z.api.answer;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.common.AnswerEnum;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.config.enums.SocialEnum;
import com.uhutu.dcom.extend.baiduPush.exception.PushClientException;
import com.uhutu.dcom.extend.baiduPush.exception.PushServerException;
import com.uhutu.dcom.extend.baiduPush.sample.BaiduPush;
import com.uhutu.dcom.extend.baiduPush.sample.PushEnum;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.request.WechatMsgAskRequest;
import com.uhutu.dcom.pay.z.response.WechatMsgResponse;
import com.uhutu.dcom.pay.z.util.WechatMsgComponent;
import com.uhutu.dcom.user.z.entity.UcClientInfo;
import com.uhutu.dcom.user.z.entity.UcSocialLogin;
import com.uhutu.dcom.user.z.entity.UcUserinfoSocial;
import com.uhutu.dcom.user.z.entity.UserBasicInfo;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.input.ApiAskWechatMsgInput;
import com.uhutu.sportcenter.z.result.ApiAskWechatMsgResult;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

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
	
	/**
	 * 发送微信消息
	 * 
	 * @param questionInfo
	 *            问题信息
	 * @return 信息响应
	 */
	public WechatMsgResponse sendWechatMsg(AwQuestionInfo questionInfo,String requestUrl) {

		WechatMsgAskRequest askRequest = new WechatMsgAskRequest();
		
		WechatMsgResponse msgResponse = null;

		UserBasicInfo userBasicInfo = userInfoSupport.getUserBasicInfo(questionInfo.getQuestionUserCode());

		UcUserinfoSocial answerSocial = userInfoSupport.getUserInfoSocial(questionInfo.getAnswerUserCode());
		
		String title = TopHelper.upInfo(88880015, userBasicInfo.getUcUserinfoExt().getNickName());
		
		/*百度push*/
		baiduPush(questionInfo.getAnswerUserCode(), title+"："+questionInfo.getContent());
		
		/*系统push*/
		answerServiceFactory.getQuestionInfoService().saveAnswerMsg("提问",title+"："+questionInfo.getContent(), questionInfo.getAnswerUserCode());
		
		if(answerSocial != null){
			
			UcSocialLogin socialLogin = JdbcHelper.queryOne(UcSocialLogin.class, "unionid",answerSocial.getAccountId(),"type",SocialEnum.wechat_h5.name());

			if(socialLogin != null){
				
				askRequest.getFirst().setValue(title+"。");

				askRequest.getKeyword1().setValue(questionInfo.getContent());

				askRequest.getKeyword2().setValue(AnswerEnum.praseText(questionInfo.getScope()));

				askRequest.getKeyword3().setValue(questionInfo.getQuestionTime());

				askRequest.getRemark().setValue(TopHelper.upInfo(88880016, questionInfo.getMoney().setScale(2).toString()));
				
				msgResponse = wechatMsgCompoent.sendMsg(socialLogin.getOpenid(), requestUrl, PayProcessEnum.WECHAT_MSG_ASK, askRequest);			
				
			}
			
		}
		
		return msgResponse;

	}
	
	public void baiduPush(String answerUserCode, String content) {

		try {

			UcClientInfo ucClientInfo = JdbcHelper.queryOne(UcClientInfo.class, "", "-zc", "",
					MapHelper.initMap("user_code", answerUserCode, "os", "ios"));

			if (ucClientInfo != null && StringUtils.isNotBlank(ucClientInfo.getChannelId())) {
				new BaiduPush().push(PushEnum.ios, "提问", content, ucClientInfo.getChannelId());
			}
			
			UcClientInfo android = JdbcHelper.queryOne(UcClientInfo.class, "", "-zc", "",
					MapHelper.initMap("user_code", answerUserCode, "os", "android"));
			
			if (android != null && StringUtils.isNotBlank(android.getChannelId())) {
				new BaiduPush().push(PushEnum.android, "提问", content, android.getChannelId());
			}
			

		} catch (PushServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PushClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
