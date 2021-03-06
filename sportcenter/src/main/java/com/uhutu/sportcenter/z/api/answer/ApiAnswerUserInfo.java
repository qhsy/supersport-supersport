package com.uhutu.sportcenter.z.api.answer;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.common.Constants;
import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.answer.z.entity.AwAnswerListen;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.AnswerUserInfo;
import com.uhutu.sportcenter.z.input.ApiAnswerUserInfoInput;
import com.uhutu.sportcenter.z.result.ApiAnswerUserInfoResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 问答用户信息
 * 
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

		AnswerUserInfo answerUserInfo = new AnswerUserInfo();

		if(expert != null){
			
			BeanUtils.copyProperties(expert, answerUserInfo);
			
		}else{
			
			answerUserInfo.setStatus(SystemEnum.NO.getCode());
			
		}

		UcUserinfoExt userInfoExt = userInfoSupport.getUserInfoExt(upUserCode());
		
		UcUserinfo ucUserinfo = userInfoSupport.getUserInfo(upUserCode());
		
		if(ucUserinfo != null){
			
			answerUserInfo.setType(ucUserinfo.getType());
			
			int listenCount = JdbcHelper.count(AwAnswerListen.class, "questionCode in (select code from aw_question_info where answer_user_code='"+upUserCode()+"')", new MDataMap());
			
			answerUserInfo.setFansNum(listenCount);
			
		}

		if (userInfoExt != null) {

			answerUserInfo.setNickName(userInfoExt.getNickName());

			answerUserInfo.setAboutHead(userInfoExt.getAboutHead());

		} else {

			result.inError(88880005);

		}
		
		int count = answerServiceFactory.getQuestionInfoService().queryAnswerCount(upUserCode(), Constants.STATUS_ANSWERED);
		
		answerUserInfo.setAnswerCount(count);

		result.setAnswerUserInfo(answerUserInfo);

		return result;

	}

}
