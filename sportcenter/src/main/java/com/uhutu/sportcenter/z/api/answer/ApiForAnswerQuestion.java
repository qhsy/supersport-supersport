package com.uhutu.sportcenter.z.api.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.request.WechatMsgAnswerRequest;
import com.uhutu.dcom.pay.z.response.WechatMsgResponse;
import com.uhutu.dcom.pay.z.util.WechatMsgComponent;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.entity.UcUserinfoSocial;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.input.ApiForAnswerQuestionInput;
import com.uhutu.sportcenter.z.result.ApiForAnswerQuestionResult;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 回答问达信息
 *
 */
@Component
public class ApiForAnswerQuestion extends RootApiToken<ApiForAnswerQuestionInput, ApiForAnswerQuestionResult> {
	
	@Autowired
	private UserInfoSupport userInfoSupport;
	
	@Autowired
	private WechatMsgComponent wechatMsgCompoent;
	
	@Autowired
	private AnswerServiceFactory answerServiceFactory;

	@Override
	protected ApiForAnswerQuestionResult process(ApiForAnswerQuestionInput input) {

		ApiForAnswerQuestionResult result = new ApiForAnswerQuestionResult();
		AwQuestionInfo qtInfo = answerServiceFactory.getQuestionInfoService().queryByCode(input.getCode());
	
		if(qtInfo != null){
			
			qtInfo.setAnswerTime(DateHelper.upNow());
			qtInfo.setCode(input.getCode());
			if (input.isRefuse()) {
				qtInfo.setStatus("dzsd4888100110010003");
			} else {
				qtInfo.setStatus("dzsd4888100110010002");
				qtInfo.setLengh(input.getLengh());
				qtInfo.setUrl(input.getUrl());
				
				WechatMsgResponse wechatMsgResponse = sendWechatMsg(qtInfo);
				
				if(!wechatMsgResponse.upFlag()){
					
					result.setStatus(0);
					
					result.setError(wechatMsgResponse.getErrmsg());
					
				}
				
			}
			
			if(result.upFlagTrue()){
				
				JdbcHelper.update(qtInfo, "status,length,url", "code");
				
			}
			
		}else{
			
			result.inError(88880022);
			
		}
		
		return result;
	}
	
	/**
	 * 发送微信消息
	 * @param questionInfo
	 * 		问题信息
	 * @return 信息响应
	 */
	public WechatMsgResponse sendWechatMsg(AwQuestionInfo questionInfo){
		
		WechatMsgAnswerRequest answerRequest = new WechatMsgAnswerRequest();
		
		UcUserinfoExt ucUserinfoExt = userInfoSupport.getUserInfoExt(upUserCode());
		
		UcUserinfoSocial ucUserinfoSocial = userInfoSupport.getUserInfoSocial(questionInfo.getQuestionUserCode());
		
		answerRequest.getFirst().setValue(TopHelper.upInfo(88880019, ucUserinfoExt.getNickName()));
		
		answerRequest.getKeyword1().setValue(ucUserinfoExt.getNickName());
		
		answerRequest.getKeyword2().setValue(questionInfo.getAnswerTime());
		
		answerRequest.getKeyword3().setValue(TopHelper.upInfo(88880020, questionInfo.getLengh()));
		
		answerRequest.getRemark().setValue(TopHelper.upInfo(88880021));
		
		return wechatMsgCompoent.sendMsg(ucUserinfoSocial.getAccountId(), "",PayProcessEnum.WECHAT_MSG_ASK, answerRequest);
		
	}

}
