package com.uhutu.sportcenter.z.api.answer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.answer.z.entity.AwAnswerExpert;
import com.uhutu.dcom.answer.z.entity.AwAnswerListen;
import com.uhutu.dcom.answer.z.entity.AwQuestionInfo;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.component.z.page.PageInfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.entity.UserBasicInfo;
import com.uhutu.dcom.user.z.support.UserInfoSupport;
import com.uhutu.sportcenter.z.entity.AnswerUserInfo;
import com.uhutu.sportcenter.z.entity.QuestionInfo;
import com.uhutu.sportcenter.z.input.ApiAnswerListenListInput;
import com.uhutu.sportcenter.z.result.ApiAnswerListenListResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 问答偷听列表
 * @author 逄小帅
 *
 */
@Component
public class ApiAnswerListenList extends RootApiToken<ApiAnswerListenListInput, ApiAnswerListenListResult> {
	
	@Autowired
	private AnswerServiceFactory answerServiceFactory;
	
	@Autowired
	private UserInfoSupport userInfoSupport;

	@Override
	protected ApiAnswerListenListResult process(ApiAnswerListenListInput input) {
		
		ApiAnswerListenListResult result = new ApiAnswerListenListResult();
		
		int count = answerServiceFactory.getAnswerListenService().queryCount(upUserCode());
		
		PageInfo pageInfo = new PageInfo(count, input.getPagination(), input.getPageNum());
		
		result.setNextFlag(pageInfo.hasNext());
		
		int iStart = (input.getPagination()-1)*input.getPageNum();
		
		List<AwAnswerListen> answerListen = answerServiceFactory.getAnswerListenService().queryList(upUserCode(), iStart, input.getPageNum());
		
		result.setQuestionInfos(convert(answerListen));
		
		result.setTotal(count);
		
		return result;
		
	}
	
	/**
	 * 初始问题信息
	 * @param awQuestionInfos
	 * 		问答信息集合
	 * @return
	 */
	public List<QuestionInfo> convert(List<AwAnswerListen> answerListens){
		
		List<QuestionInfo> questionInfos = new ArrayList<QuestionInfo>();
		
		answerListens.forEach(answerListen -> {
			
			QuestionInfo questionInfo = new QuestionInfo();
			
			AwQuestionInfo awQuestionInfo = answerServiceFactory.getQuestionInfoService().queryByCode(answerListen.getQuestionCode());
			
			if(awQuestionInfo != null){
				
				BeanUtils.copyProperties(awQuestionInfo, questionInfo);
				
			}
			
			questionInfo.setUserCode(awQuestionInfo.getAnswerUserCode());
			
			UserBasicInfo userBasicInfo = userInfoSupport.getUserBasicInfo(questionInfo.getUserCode());
			
			questionInfo.setAboutHead(userBasicInfo.getUcUserinfoExt().getAboutHead());
			
			questionInfo.setNickName(userBasicInfo.getUcUserinfoExt().getNickName());
			
			questionInfo.setType(userBasicInfo.getUcUserinfo().getType());
			
			AnswerUserInfo answerUserInfo = new AnswerUserInfo();
			
			UcUserinfoExt ucUserinfoExt = userInfoSupport.getUserInfoExt(awQuestionInfo.getAnswerUserCode());
			
			answerUserInfo.setNickName(ucUserinfoExt.getNickName());
			
			answerUserInfo.setAboutHead(ucUserinfoExt.getAboutHead());
			
			AwAnswerExpert expert = answerServiceFactory.getAwAnswerExpertService().getByUserCode(awQuestionInfo.getAnswerUserCode());
			
			answerUserInfo.setTitle(expert.getTitle());
			
			questionInfo.setAnswerUserInfo(answerUserInfo);
			
			questionInfos.add(questionInfo);
			
		});
		
		return questionInfos;
		
		
	}

}
