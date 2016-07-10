package com.uhutu.sportcenter.z.api.answer;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.answer.z.common.AnswerEnum;
import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.request.WechatMsgAskRequest;
import com.uhutu.dcom.pay.z.response.WechatMsgResponse;
import com.uhutu.dcom.pay.z.util.WechatMsgComponent;
import com.uhutu.dcom.user.z.entity.UcUserinfoSocial;
import com.uhutu.dcom.user.z.entity.UserBasicInfo;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.input.ApiForAskQuestionInput;
import com.uhutu.sportcenter.z.result.ApiForAskQuestionResult;
import com.uhutu.zoocom.helper.DateHelper;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;

/**
 * 提问信息
 *
 */
@Component
public class ApiForAskQuestion extends RootApiToken<ApiForAskQuestionInput, ApiForAskQuestionResult> {
	
	@Autowired
	private UserInfoSupport userInfoSupport;
	
	@Autowired
	private WechatMsgComponent wechatMsgCompoent;

	@Override
	protected ApiForAskQuestionResult process(ApiForAskQuestionInput input) {

		ApiForAskQuestionResult result = new ApiForAskQuestionResult();
		AwQuestionInfo qtInfo = new AwQuestionInfo();
		AwAnswerExpert answerExpert = JdbcHelper.queryOne(AwAnswerExpert.class, "userCode", input.getAnswerUserCode());
		if (answerExpert != null && "dzsd4699100110010001".equals(answerExpert.getStatus())) {
			qtInfo.setAnswerUserCode(input.getAnswerUserCode());
			qtInfo.setContent(input.getContent());
			
			if(StringUtils.isNotEmpty(input.getScope())){
				
				boolean scope = Boolean.valueOf(input.getScope());
				
				qtInfo.setScope(scope?AnswerEnum.SCOPE_PUBLIC.getCode():AnswerEnum.SCOPE_PRIVATE.getCode());
				
				
			}else{
				
				qtInfo.setScope(AnswerEnum.SCOPE_PUBLIC.getCode());
				
			}
			
			qtInfo.setStatus("dzsd4888100110010001");
			qtInfo.setSellMoney(BigDecimal.valueOf(1));
			qtInfo.setQuestionUserCode(upUserCode());
			qtInfo.setQuestionTime(DateHelper.upNow());
			qtInfo.setMoney(answerExpert.getCharge());
			qtInfo.setCode(WebHelper.upCode("WDBH"));
			JdbcHelper.insert(qtInfo);
			result.setCode(qtInfo.getCode());
			
			WechatMsgResponse wechatMsgResponse = sendWechatMsg(qtInfo);
			
			if(!wechatMsgResponse.upFlag()){
				
				result.setStatus(0);
				
				result.setError(wechatMsgResponse.getErrmsg());
				
			}
			
		} else {
			result.inError(88880007);
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
		
		WechatMsgAskRequest askRequest = new WechatMsgAskRequest();
		
		UserBasicInfo userBasicInfo = userInfoSupport.getUserBasicInfo(questionInfo.getQuestionUserCode());
		
		UcUserinfoSocial answerSocial = userInfoSupport.getUserInfoSocial(questionInfo.getAnswerUserCode());
		
		askRequest.getFirst().setValue(TopHelper.upInfo(88880015, userBasicInfo.getUcUserinfoExt().getNickName()));
		
		askRequest.getKeyword1().setValue(questionInfo.getContent());
		
		askRequest.getKeyword2().setValue(AnswerEnum.praseText(questionInfo.getScope()));
		
		askRequest.getKeyword3().setValue(questionInfo.getQuestionTime());
		
		askRequest.getRemark().setValue(TopHelper.upInfo(88880016, questionInfo.getMoney().setScale(2).toString()));
		
		return wechatMsgCompoent.sendMsg(answerSocial.getAccountId(), "",PayProcessEnum.WECHAT_MSG_ASK, askRequest);
		
	}

}
