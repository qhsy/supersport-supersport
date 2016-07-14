package com.uhutu.sportcenter.z.api.answer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.activity.z.entity.AcActivityAnswerInfo;
import com.uhutu.dcom.activity.z.support.AnswerActivitySupport;
import com.uhutu.dcom.answer.z.common.AnswerEnum;
import com.uhutu.dcom.answer.z.common.Constants;
import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.answer.z.support.QuestionSupport;
import com.uhutu.dcom.user.z.entity.UcAttentionInfo;
import com.uhutu.dcom.user.z.entity.UserBasicInfo;
import com.uhutu.dcom.user.z.enums.UserEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.AnswerUserInfo;
import com.uhutu.sportcenter.z.entity.QuestionInfo;
import com.uhutu.sportcenter.z.input.ApiPersonHomeInput;
import com.uhutu.sportcenter.z.result.ApiPersonHomeResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zooweb.user.UserCallFactory;

/**
 * 个人主页
 * @author 逄小帅
 *
 */
@Component
public class ApiPersonHome extends RootApiBase<ApiPersonHomeInput, ApiPersonHomeResult> {
	
	@Autowired
	private AnswerServiceFactory answerServiceFactory;
	
	@Autowired
	private UserInfoSupport userInfoSupport;
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiPersonHomeResult process(ApiPersonHomeInput input) {
		
		ApiPersonHomeResult result = new ApiPersonHomeResult();
		
		String attendUserCode = "";
		
		AwAnswerExpert answerExpert = answerServiceFactory.getAwAnswerExpertService().getByUserCode(input.getUserCode());
		
		if(answerExpert == null){
			
			result.inError(88880004);
			
		}
		
		if(result.upFlagTrue()){
			
			int count = answerServiceFactory.getQuestionInfoService().queryAnswerCount(input.getUserCode(), Constants.STATUS_ANSWERED);
			
			int iStart = (input.getPagination() - 1)*20;
			
			List<AwQuestionInfo> awQuestionInfos = answerServiceFactory.getQuestionInfoService().queryAnswerList(input.getUserCode(),AnswerEnum.SCOPE_PUBLIC.getCode(), Constants.STATUS_ANSWERED, iStart, 20);
			
			AnswerUserInfo answerUserInfo = new AnswerUserInfo();
			
			BeanUtils.copyProperties(answerExpert, answerUserInfo);
			
			UserBasicInfo userBasicInfo = userInfoSupport.getUserBasicInfo(input.getUserCode());
			
			answerUserInfo.setAboutHead(userBasicInfo.getUcUserinfoExt().getAboutHead());
			
			answerUserInfo.setNickName(userBasicInfo.getUcUserinfoExt().getNickName());
			
			answerUserInfo.setAnswerCount(count);
			
			answerUserInfo.setType(userBasicInfo.getUcUserinfo().getType());
			
			UcAttentionInfo attendInfo = null;
			
			if(StringUtils.isNotEmpty(input.getZoo().getToken())){
				
				attendUserCode = new UserCallFactory().upUserCodeByAuthToken(input.getZoo().getToken(), DefineUser.Login_System_Default);
				
				attendInfo = userServiceFactory.getAttentionInfoService()
					.queryByBothCode(attendUserCode, input.getUserCode(),UserEnum.ATTEND.getCode());
				
			}
			
			if(attendInfo != null){
				
				answerUserInfo.setAttendFlag(attendInfo.getStatus());
				
			}else{
				
				answerUserInfo.setAttendFlag(UserEnum.UN_ATTEND.getCode());
				
			}
			
			result.setQuestionInfos(convert(awQuestionInfos,attendUserCode));
			
			result.setAnswerUserInfo(answerUserInfo);
			
		}
		
		return result;
	}
	
	/**
	 * 初始问题信息
	 * @param awQuestionInfos
	 * 		问答信息集合
	 * @return
	 */
	public List<QuestionInfo> convert(List<AwQuestionInfo> awQuestionInfos,String listenUserCode){
		
		List<QuestionInfo> questionInfos = new ArrayList<QuestionInfo>();
		
		awQuestionInfos.forEach(awQuestionInfo -> {
			
			QuestionInfo questionInfo = new QuestionInfo();
			
			BeanUtils.copyProperties(awQuestionInfo, questionInfo);
			
			questionInfo.setUserCode(awQuestionInfo.getQuestionUserCode());
			
			UserBasicInfo userBasicInfo = userInfoSupport.getUserBasicInfo(questionInfo.getUserCode());
			
			questionInfo.setAboutHead(userBasicInfo.getUcUserinfoExt().getAboutHead());
			
			questionInfo.setNickName(userBasicInfo.getUcUserinfoExt().getNickName());
			
			questionInfo.setType(userBasicInfo.getUcUserinfo().getType());
			
			questionInfo.setPraiseNum(awQuestionInfo.getLove());
			
			questionInfo.setSoundContent(QuestionSupport.soundContent(awQuestionInfo.getCode()));
			
			questionInfo.setListenFlag(new QuestionSupport().checkUserLitenTheQuestion(listenUserCode, awQuestionInfo.getCode()));
			
			AcActivityAnswerInfo activityAnswerInfo = new AnswerActivitySupport().getActivityInfoByAnswerCode(awQuestionInfo.getCode());
			
			if(activityAnswerInfo != null){
				
				questionInfo.setActivityFlag(true);
				
			}
			
			questionInfos.add(questionInfo);
			
		});
		
		return questionInfos;
		
		
	}

}
