package com.uhutu.sportcenter.z.api.answer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 个人主页
 * @author 逄小帅
 *
 */
@Component
public class ApiPersonHome extends RootApiToken<ApiPersonHomeInput, ApiPersonHomeResult> {
	
	@Autowired
	private AnswerServiceFactory answerServiceFactory;
	
	@Autowired
	private UserInfoSupport userInfoSupport;
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiPersonHomeResult process(ApiPersonHomeInput input) {
		
		ApiPersonHomeResult result = new ApiPersonHomeResult();
		
		AwAnswerExpert answerExpert = answerServiceFactory.getAwAnswerExpertService().getByUserCode(input.getUserCode());
		
		if(answerExpert == null){
			
			result.inError(88880004);
			
		}
		
		if(result.upFlagTrue()){
			
			int count = answerServiceFactory.getQuestionInfoService().queryAnswerCount(input.getUserCode(), Constants.STATUS_ANSWERED);
			
			int iStart = (input.getPagination() - 1)*20;
			
			List<AwQuestionInfo> awQuestionInfos = answerServiceFactory.getQuestionInfoService().queryAnswerList(input.getUserCode(), Constants.STATUS_ANSWERED, iStart, 20);
			
			result.setQuestionInfos(convert(awQuestionInfos));
			
			AnswerUserInfo answerUserInfo = new AnswerUserInfo();
			
			BeanUtils.copyProperties(answerExpert, answerUserInfo);
			
			UserBasicInfo userBasicInfo = userInfoSupport.getUserBasicInfo(input.getUserCode());
			
			answerUserInfo.setAboutHead(userBasicInfo.getUcUserinfoExt().getAboutHead());
			
			answerUserInfo.setNickName(userBasicInfo.getUcUserinfoExt().getNickName());
			
			answerUserInfo.setAnswerCount(count);
			
			answerUserInfo.setType(userBasicInfo.getUcUserinfo().getType());
			
			UcAttentionInfo attendInfo = userServiceFactory.getAttentionInfoService()
					.queryByBothCode(upUserCode(), input.getUserCode(),UserEnum.ATTEND.getCode());
			
			if(attendInfo != null){
				
				answerUserInfo.setAttendFlag(attendInfo.getStatus());
				
			}else{
				
				answerUserInfo.setAttendFlag(UserEnum.UN_ATTEND.getCode());
				
			}
			
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
	public List<QuestionInfo> convert(List<AwQuestionInfo> awQuestionInfos){
		
		List<QuestionInfo> questionInfos = new ArrayList<QuestionInfo>();
		
		awQuestionInfos.forEach(awQuestionInfo -> {
			
			QuestionInfo questionInfo = new QuestionInfo();
			
			BeanUtils.copyProperties(awQuestionInfo, questionInfo);
			
			questionInfo.setUserCode(awQuestionInfo.getQuestionUserCode());
			
			UserBasicInfo userBasicInfo = userInfoSupport.getUserBasicInfo(questionInfo.getUserCode());
			
			questionInfo.setAboutHead(userBasicInfo.getUcUserinfoExt().getAboutHead());
			
			questionInfo.setNickName(userBasicInfo.getUcUserinfoExt().getNickName());
			
			questionInfo.setType(userBasicInfo.getUcUserinfo().getType());
			
			questionInfo.setPraiseNum(0);
			
			questionInfo.setSoundContent(QuestionSupport.soundContent(awQuestionInfo.getCode()));
			
			questionInfos.add(questionInfo);
			
		});
		
		return questionInfos;
		
		
	}

}
